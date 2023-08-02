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
public abstract class AbstractRequestAuthenticator implements RequestAuthenticator {
    private static final String TOKEN_PATTERN = "mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%d\",serial_no=\"%s\",signature=\"%s\"";
    private static final AlternativeJdkIdGenerator ID_GENERATOR = new AlternativeJdkIdGenerator();
    private final MerchantKeyLoader merchantKeyLoader;

    /**
     * Instantiates a new Abstract request authenticator.
     *
     * @param merchantKeyLoader the merchant key loader
     */
    public AbstractRequestAuthenticator(MerchantKeyLoader merchantKeyLoader) {
        this.merchantKeyLoader = merchantKeyLoader;
    }

    @SneakyThrows
    @Override
    public final String authHeader(String merchantId, URI uri, String httpMethod, String body) {

        final RequestAuthType authType = requestAuthType();
        String canonicalUrl = Optional.ofNullable(uri.getRawQuery())
                .map(query ->
                        uri.getRawPath().concat("?").concat(query))
                .orElse(uri.getRawPath());
        String signBody = Optional.ofNullable(body).orElse("");

        String nonceStr = ID_GENERATOR.generate32();
        long timestamp = Instant.now().getEpochSecond();
        final String signMessage = buildSignMessage(httpMethod, canonicalUrl, String.valueOf(timestamp), nonceStr, signBody);
        MerchantKey merchantKey = merchantKeyLoader.loadByMerchantId(merchantId, authType);

        Signature signer = Signature.getInstance(authType.getAlg());
        signer.initSign(merchantKey.getKeyPair().getPrivate());
        signer.update(signMessage.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64Utils.encodeToString(signer.sign());
        String token = String.format(TOKEN_PATTERN, merchantId, nonceStr, timestamp, merchantKey.getSerialNumber(), encoded);
        return authType.toAuthHeader(token);
    }

    /**
     * Request auth type request auth type.
     *
     * @return the request auth type
     */
    protected abstract RequestAuthType requestAuthType();


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
