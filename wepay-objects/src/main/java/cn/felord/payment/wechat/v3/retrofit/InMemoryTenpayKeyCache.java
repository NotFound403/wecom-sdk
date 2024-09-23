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
 * @since 2024/8/16 11:38
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
