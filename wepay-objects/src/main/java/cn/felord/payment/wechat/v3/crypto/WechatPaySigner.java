/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.payment.wechat.v3.crypto;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.retrofit.HttpHeaders;
import cn.felord.utils.AlternativeJdkIdGenerator;
import cn.felord.utils.Base64Utils;
import lombok.SneakyThrows;
import okhttp3.Headers;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 默认签名工具
 *
 * @author dax
 * @since 2024/8/10 16:57
 */
public final class WechatPaySigner {
    private static final String TOKEN_PATTERN = "mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%d\",serial_no=\"%s\",signature=\"%s\"";
    private static final AlternativeJdkIdGenerator ID_GENERATOR = new AlternativeJdkIdGenerator();

    private WechatPaySigner() {
    }

    /**
     * Sign string.
     *
     * @param appMerchant the app merchant
     * @param uri         the uri
     * @param httpMethod  the http method
     * @param body        the body
     * @return the string
     */
    @SneakyThrows
    public static String sign(AppMerchant appMerchant, URI uri, String httpMethod, String body) {
        String canonicalUrl = Optional.ofNullable(uri.getRawQuery())
                .map(query ->
                        uri.getRawPath().concat("?").concat(query))
                .orElse(uri.getRawPath());
        String nonceStr = ID_GENERATOR.generate32();
        long timestamp = Instant.now().getEpochSecond();
        final String signMessage = buildSignMessage(httpMethod, canonicalUrl, String.valueOf(timestamp), nonceStr, body);
        AuthType authType = appMerchant.authType();
        Signature signer = Signature.getInstance(authType.alg());
        signer.initSign(appMerchant.privateKey());
        signer.update(signMessage.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64Utils.encodeToString(signer.sign());
        String token = String.format(TOKEN_PATTERN, appMerchant.merchantId(), nonceStr, timestamp, appMerchant.serialNumber(), encoded);
        return authType.toAuthHeader(token);
    }

    /**
     * Sign string.
     *
     * @param appMerchant       the app merchant
     * @param orderedComponents the ordered components
     * @return the string
     */
    @SneakyThrows
    public static String sign(AppMerchant appMerchant, String... orderedComponents) {
        final String signMessage = buildSignMessage(orderedComponents);
        AuthType authType = appMerchant.authType();
        Signature signer = Signature.getInstance(authType.alg());
        signer.initSign(appMerchant.privateKey());
        signer.update(signMessage.getBytes(StandardCharsets.UTF_8));
        return Base64Utils.encodeToString(signer.sign());
    }

    /**
     * Verify boolean.
     *
     * @param responseHeaders the response headers
     * @param body            the body
     * @param tenpayKey       the tenpay key
     * @return the boolean
     */
    public static boolean verify(Headers responseHeaders, String body, TenpayKey tenpayKey) {
        String wechatpaySignature = Objects.requireNonNull(responseHeaders.get(HttpHeaders.WECHAT_PAY_SIGNATURE.headerName()));
        String wechatpaySignatureType = responseHeaders.get(HttpHeaders.WECHAT_PAY_SIGNATURE_TYPE.headerName());
        String wechatpayTimestamp = responseHeaders.get(HttpHeaders.WECHAT_PAY_TIMESTAMP.headerName());
        String wechatpayNonce = responseHeaders.get(HttpHeaders.WECHAT_PAY_NONCE.headerName());
        final String message = buildSignMessage(wechatpayTimestamp, wechatpayNonce, body);
        AuthType authType = AuthType.fromSignType(wechatpaySignatureType);
        try {
            Signature signer = Signature.getInstance(authType.alg());
            signer.initVerify(tenpayKey.toPublicKey());
            signer.update(message.getBytes(StandardCharsets.UTF_8));
            return signer.verify(Base64Utils.decodeFromString(wechatpaySignature));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new PayException("Signature verification failed", e);
        }
    }

    /**
     * 请求时设置签名   组件
     *
     * @param components the components
     * @return string string
     */
    private static String buildSignMessage(String... components) {
        return Arrays.stream(components)
                .collect(Collectors.joining("\n", "", "\n"));
    }
}
