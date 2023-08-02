package cn.felord.payment.wechat.v3.crypto;

import cn.felord.payment.PayException;

/**
 * The interface Merchant key loader.
 *
 * @author felord.cn
 * @since 2.0.0
 */
public interface MerchantKeyLoader {
    /**
     * 加载商户Key
     *
     * @param merchantId the merchant id
     * @param authType   the auth type
     * @return the merchant key
     * @throws PayException the pay exception
     */
    MerchantKey loadByMerchantId(String merchantId, RequestAuthType authType) throws PayException;
}
