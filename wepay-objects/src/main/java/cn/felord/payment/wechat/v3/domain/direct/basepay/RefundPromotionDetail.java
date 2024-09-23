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

package cn.felord.payment.wechat.v3.domain.direct.basepay;

import cn.felord.payment.wechat.enumeration.PromotionScope;
import cn.felord.payment.wechat.enumeration.RefundPromotionType;
import lombok.Data;

import java.util.List;

/**
 * 优惠退款信息
 *
 * @author felord.cn
 * @since 2023/8/17 15:58
 */
@Data
public class RefundPromotionDetail {

    /**
     * 券或者立减优惠id
     */
    private String promotionId;
    /**
     * 优惠范围
     * <ul>
     *     <li>GLOBAL：全场代金券</li>
     *     <li>SINGLE：单品优惠</li>
     * </ul>
     */
    private PromotionScope scope;
    /**
     * 优惠类型
     * <ul>
     *     <li>COUPON：代金券，需要走结算资金的充值型代金券</li>
     *     <li>DISCOUNT：优惠券，不走结算资金的免充值型优惠券</li>
     * </ul>
     */
    private RefundPromotionType type;
    /**
     * 优惠券面额，单位【分】
     */
    private Long amount;
    /**
     * 优惠退款金额小于等于退款金额，退款金额-代金券或立减优惠退款金额为用户支付的现金，说明详见代金券或立减优惠，单位为分
     */
    private Long refundAmount;
    /**
     * 单品列表信息
     */
    private List<RefundGoodsDetail> goodsDetail;
}
