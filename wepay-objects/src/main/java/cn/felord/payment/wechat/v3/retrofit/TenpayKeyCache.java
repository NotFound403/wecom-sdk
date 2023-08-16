package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;

/**
 * 全局平台证书缓存抽象
 *
 * @author dax
 * @since 2023 /8/16 10:58
 */
public interface TenpayKeyCache {

    /**
     * 放入缓存，过期可参考jwk的过期时间设置
     * <p>
     * key格式推荐{@code merchantId::serialNumber}
     *
     * @param merchantId   商户号
     * @param serialNumber 证书序列号
     * @param tenpayKey    平台证书
     */
    void putTenpayKey(String merchantId, String serialNumber, TenpayKey tenpayKey);

    /**
     * 取出证书缓存
     *
     * @param merchantId   商户号
     * @param serialNumber 证书序列号
     * @return the jwk
     * @throws PayException the pay exception
     */
    TenpayKey getTenpayKey(String merchantId, String serialNumber) throws PayException;
}
