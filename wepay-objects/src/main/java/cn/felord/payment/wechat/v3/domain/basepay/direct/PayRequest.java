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
package cn.felord.payment.wechat.v3.domain.basepay.direct;


import cn.felord.payment.wechat.v3.domain.basepay.PayParams;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 支付请求参数.
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class PayRequest extends PayParams {
    private final String appid;
    private final String mchid;


    /**
     * Instantiates a new Pay request.
     *
     * @param mchid     the mchid
     * @param appid     the appid
     * @param payParams the pay params
     */
    public PayRequest(String mchid, String appid, PayParams payParams) {
        super(payParams.getDescription(), payParams.getOutTradeNo(), payParams.getNotifyUrl(), payParams.getAmount(), payParams.getPayer());
        this.appid = appid;
        this.mchid = mchid;
    }
}
