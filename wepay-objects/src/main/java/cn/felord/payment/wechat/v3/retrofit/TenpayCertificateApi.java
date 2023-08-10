package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.Merchant;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信支付平台证书API
 *
 * @author dax
 * @since 2023 /8/10 10:04
 */
final class TenpayCertificateApi {

    private final WechatPayRetrofitFactory factory;

    /**
     * Instantiates a new Tenpay certificate api.
     *
     * @param wechatPaySigner the wechat pay signer
     */
    TenpayCertificateApi(WechatPaySigner wechatPaySigner) {
        this.factory = new WechatPayRetrofitFactory(wechatPaySigner);
    }

    /**
     * 根据商户号和v3密钥获取平台证书列表
     *
     * @param merchant the merchant
     * @return the list
     * @throws PayException the pay exception
     */
    public List<TenpayKey> certificates(Merchant merchant) throws PayException {
        return factory.merchant(merchant.getMerchantId())
                .create(InternalCertificateApi.class)
                .certificates()
                .getData()
                .stream()
                .map(tenpayCertificate ->
                        new TenpayKey(tenpayCertificate.getSerialNo(),
                                tenpayCertificate.getEncryptCertificate().toJwk(merchant.getAppV3Secret())))
                .collect(Collectors.toList());
    }
}
