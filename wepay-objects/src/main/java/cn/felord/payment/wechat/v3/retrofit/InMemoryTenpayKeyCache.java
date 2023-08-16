package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type In memory tenpay key cache.
 *
 * @author dax
 * @since 2023 /8/16 11:38
 */
public class InMemoryTenpayKeyCache implements TenpayKeyCache {
    private static final Map<String, TenpayKey> TENPAY_KEYS = new ConcurrentHashMap<>();

    @Override
    public void putTenpayKey(String merchantId, String serialNumber, TenpayKey tenpayKey) {
        TENPAY_KEYS.put(merchantId.concat("::").concat(serialNumber), tenpayKey);
    }

    @Override
    public TenpayKey getTenpayKey(String merchantId, String serialNumber) throws PayException {
        TenpayKey tenpayKey = TENPAY_KEYS.get(merchantId.concat("::").concat(serialNumber));
        return Objects.isNull(tenpayKey) || tenpayKey.expired() ? null : tenpayKey;
    }
}
