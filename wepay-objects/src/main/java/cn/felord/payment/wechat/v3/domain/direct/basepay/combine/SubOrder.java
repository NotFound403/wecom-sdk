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
package cn.felord.payment.wechat.v3.domain.direct.basepay.combine;

import cn.felord.payment.wechat.v3.domain.direct.basepay.SettleInfo;
import cn.felord.payment.wechat.v3.domain.direct.basepay.TotalAmount;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 子单信息，最多50单.
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@RequiredArgsConstructor
@Getter
public class SubOrder {
    /**
     * 子单发起方商户号，必填，必须与发起方appid有绑定关系。
     */
    private final String mchid;
    /**
     * 附加数据，必填，在查询API和支付通知中原样返回，可作为自定义参数使用。
     */
    private final String attach;
    /**
     * 合单支付订单金额信息，必填。
     */
    private final TotalAmount amount;
    /**
     * 子单商户订单号，必填，商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private final String outTradeNo;
    /**
     * 商品描述，必填，需传入应用市场上的APP名字-实际商品名称，例如：天天爱消除-游戏充值。
     */
    private final String description;
    /**
     * 订单优惠标记，使用代金券或立减优惠功能时需要的参数，
     * 参见<a href="https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_7&index=3">金券或立减优惠</a>
     */
    private String goodsTag;
    /**
     * 结算信息，选填
     */
    private SettleInfo settleInfo;

    /**
     * Instantiates a new Sub order.
     *
     * @param mchid       the mchid
     * @param attach      the attach
     * @param amount      the amount
     * @param outTradeNo  the out trade no
     * @param description the description
     * @param goodsTag    the goods tag
     * @param settleInfo  the settle info
     */
    @JsonCreator
    SubOrder(@JsonProperty("mchid") String mchid,
             @JsonProperty("attach") String attach,
             @JsonProperty("amount") TotalAmount amount,
             @JsonProperty("out_trade_no") String outTradeNo,
             @JsonProperty("description") String description,
             @JsonProperty("goods_tag") String goodsTag,
             @JsonProperty("settle_info") SettleInfo settleInfo) {
        this.mchid = mchid;
        this.attach = attach;
        this.amount = amount;
        this.outTradeNo = outTradeNo;
        this.description = description;
        this.goodsTag = goodsTag;
        this.settleInfo = settleInfo;
    }
}
