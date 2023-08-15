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

package cn.felord.payment.wechat.v3.retrofit;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.Merchant;
import cn.felord.payment.wechat.v3.crypto.TenpayKey;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 微信支付平台证书API
 *
 * @author dax
 * @since 2023 /8/10 10:04
 */
final class TenpayCertificateApi {

    private final WechatPayRetrofitFactory factory;
    private static final Set<TenpayKey> TENPAY_KEYS = Collections.synchronizedSet(new HashSet<>());

    /**
     * Instantiates a new Tenpay certificate api.
     *
     * @param factory the factory
     */
    TenpayCertificateApi(WechatPayRetrofitFactory factory) {
        this.factory = factory;
    }

    /**
     * 根据商户号和v3密钥获取平台证书列表
     *
     * @param merchantId the merchant id
     * @throws PayException the pay exception
     */
    public void certificates(String merchantId) throws PayException {
        Merchant merchant = factory.merchantService().loadMerchant(merchantId);
        Set<TenpayKey> tenpayKeys = factory.merchant(merchant.getMerchantId())
                .create(InternalCertificateApi.class)
                .certificates()
                .getData()
                .stream()
                .map(tenpayCertificate ->
                        new TenpayKey(merchantId, tenpayCertificate.getSerialNo(),
                                tenpayCertificate.getEncryptCertificate().toJwk(merchant.getApiV3Secret())))
                .collect(Collectors.toSet());
        TENPAY_KEYS.addAll(tenpayKeys);
    }

    /**
     * Gets tenpay key.
     *
     * @param serialNumber the serial number
     * @param merchantId   the merchant id
     * @return the tenpay key
     */
    public TenpayKey getTenpayKey(String serialNumber, String merchantId) {
        return TENPAY_KEYS.stream()
                .filter(tenpayKey ->
                        Objects.equals(tenpayKey.getSerialNumber(), serialNumber))
                .filter(tenpayKey -> {
                    boolean after = tenpayKey.getTenPayJwk()
                            .getExpirationTime()
                            .after(new Date());
                    if (!after) {
                        TENPAY_KEYS.remove(tenpayKey);
                    }
                    return after;
                })
                .findAny()
                .orElseGet(() -> {
                    certificates(merchantId);
                    return TENPAY_KEYS.stream()
                            .filter(tenpayKey ->
                                    Objects.equals(tenpayKey.getSerialNumber(), serialNumber))
                            .findAny()
                            .orElseThrow(() -> new PayException("Fail to load tenpayKey"));
                });
    }

}
