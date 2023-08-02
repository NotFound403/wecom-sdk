package cn.felord.payment.wechat.v3.crypto;

/**
 * The type Rsa request authenticator.
 *
 * @author felord.cn
 * @since 2.0.0
 */
public class RsaRequestAuthenticator extends AbstractRequestAuthenticator {
    /**
     * Instantiates a new Abstract request authenticator.
     *
     * @param merchantKeyLoader the merchant key loader
     */
    public RsaRequestAuthenticator(MerchantKeyLoader merchantKeyLoader) {
        super(merchantKeyLoader);
    }

    @Override
    protected RequestAuthType requestAuthType() {
        return RequestAuthType.SHA256_RSA2048;
    }
}
