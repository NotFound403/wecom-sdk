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

package cn.felord.payment.wechat.v3.domain.basepay.partner;

import cn.felord.payment.wechat.v3.domain.basepay.Amount;
import cn.felord.payment.wechat.v3.domain.basepay.PayParams;
import cn.felord.payment.wechat.v3.domain.basepay.Payer;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The type Partner pay request.
 *
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class PartnerPayRequest extends PayParams {
    /**
     * 服务商公众号ID
     */
    private final String spAppid;
    /**
     * 服务商户号
     */
    private final String spMchid;
    /**
     * 子商户号
     */
    private final String subMchid;
    /**
     * 子商户appid.
     */
    private final String subAppid;

    /**
     * Instantiates a new Partner pay request.
     *
     * @param description the description
     * @param outTradeNo  the out trade no
     * @param notifyUrl   the notify url
     * @param amount      the amount
     * @param payer       the payer
     * @param spAppid     the sp appid
     * @param spMchid     the sp mchid
     * @param subMchid    the sub mchid
     */
    public PartnerPayRequest(String description, String outTradeNo, String notifyUrl, Amount amount, Payer payer, String spAppid, String spMchid, String subMchid) {
        this(description, outTradeNo, notifyUrl, amount, payer, spAppid, spMchid, subMchid, null);
    }

    /**
     * Instantiates a new Partner pay request.
     *
     * @param description the description
     * @param outTradeNo  the out trade no
     * @param notifyUrl   the notify url
     * @param amount      the amount
     * @param payer       the payer
     * @param spAppid     the sp appid
     * @param spMchid     the sp mchid
     * @param subMchid    the sub mchid
     * @param subAppid    the sub appid
     */
    public PartnerPayRequest(String description, String outTradeNo, String notifyUrl, Amount amount, Payer payer, String spAppid, String spMchid, String subMchid, String subAppid) {
        super(description, outTradeNo, notifyUrl, amount, payer);
        this.spAppid = spAppid;
        this.spMchid = spMchid;
        this.subMchid = subMchid;
        this.subAppid = subAppid;
    }
}
