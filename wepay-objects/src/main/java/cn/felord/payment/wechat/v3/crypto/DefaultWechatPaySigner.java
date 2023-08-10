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
 * The type Default wechat pay signer.
 *
 * @author dax
 * @since 2023 /8/10 16:57
 */
public class DefaultWechatPaySigner implements WechatPaySigner {
    private static final String TOKEN_PATTERN = "mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%d\",serial_no=\"%s\",signature=\"%s\"";
    private static final AlternativeJdkIdGenerator ID_GENERATOR = new AlternativeJdkIdGenerator();
    private final MerchantKeyLoader merchantKeyLoader;

    public DefaultWechatPaySigner(MerchantKeyLoader merchantKeyLoader) {
        this.merchantKeyLoader = merchantKeyLoader;
    }

    @SneakyThrows
    @Override
    public String sign(String merchantId, URI uri, String httpMethod, String body) {
        String canonicalUrl = Optional.ofNullable(uri.getRawQuery())
                .map(query ->
                        uri.getRawPath().concat("?").concat(query))
                .orElse(uri.getRawPath());
        String nonceStr = ID_GENERATOR.generate32();
        long timestamp = Instant.now().getEpochSecond();
        final String signMessage = buildSignMessage(httpMethod, canonicalUrl, String.valueOf(timestamp), nonceStr, body);
        MerchantKey merchantKey = merchantKeyLoader.loadByMerchantId(merchantId);
        AuthType authType = merchantKey.authType();
        Signature signer = Signature.getInstance(authType.alg());
        signer.initSign(merchantKey.privateKey());
        signer.update(signMessage.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64Utils.encodeToString(signer.sign());
        String token = String.format(TOKEN_PATTERN, merchantId, nonceStr, timestamp, merchantKey.serialNumber(), encoded);
        return authType.toAuthHeader(token);
    }

    @Override
    public boolean verify(ResponseSignVerifyParams params) {
        return false;
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
