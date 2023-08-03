/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.payment.wechat.v3.crypto;

import cn.felord.utils.AlternativeJdkIdGenerator;
import cn.felord.utils.Base64Utils;
import lombok.SneakyThrows;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.Signature;
import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Abstract request authenticator.
 *
 * @author felord.cn
 * @since 2.0.0
 */
public class DefaultRequestAuthenticator implements RequestAuthenticator {
    private static final String TOKEN_PATTERN = "mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%d\",serial_no=\"%s\",signature=\"%s\"";
    private static final AlternativeJdkIdGenerator ID_GENERATOR = new AlternativeJdkIdGenerator();
    private final MerchantKeyLoader merchantKeyLoader;

    /**
     * Instantiates a new Abstract request authenticator.
     *
     * @param merchantKeyLoader the merchant key loader
     */
    public DefaultRequestAuthenticator(MerchantKeyLoader merchantKeyLoader) {
        this.merchantKeyLoader = merchantKeyLoader;
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

    @SneakyThrows
    @Override
    public final String authHeader(MerchantConfig merchantConfig, URI uri, String httpMethod, String body) {

        String canonicalUrl = Optional.ofNullable(uri.getRawQuery())
                .map(query ->
                        uri.getRawPath().concat("?").concat(query))
                .orElse(uri.getRawPath());
        String signBody = Optional.ofNullable(body).orElse("");

        String nonceStr = ID_GENERATOR.generate32();
        long timestamp = Instant.now().getEpochSecond();
        final String signMessage = buildSignMessage(httpMethod, canonicalUrl, String.valueOf(timestamp), nonceStr, signBody);
        MerchantKey merchantKey = merchantKeyLoader.loadByMerchantId(merchantConfig);
        RequestAuthType authType = merchantConfig.getRequestAuthType();
        Signature signer = Signature.getInstance(authType.alg());
        signer.initSign(merchantKey.toPrivateKey());
        signer.update(signMessage.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64Utils.encodeToString(signer.sign());
        String token = String.format(TOKEN_PATTERN, merchantConfig.getMerchantId(), nonceStr, timestamp, merchantKey.obtainSerialNumber(), encoded);
        return authType.toAuthHeader(token);
    }
}
