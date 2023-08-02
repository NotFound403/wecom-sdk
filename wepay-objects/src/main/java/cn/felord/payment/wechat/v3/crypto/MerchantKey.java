package cn.felord.payment.wechat.v3.crypto;

import lombok.Data;

import java.security.KeyPair;

/**
 * The type Merchant key.
 *
 * @author felord.cn
 * @since 2.0.0
 */
@Data
public final class MerchantKey {
    private final String merchantId;
    private final RequestAuthType requestAuthType;
    private final String serialNumber;
    private final KeyPair keyPair;
}
