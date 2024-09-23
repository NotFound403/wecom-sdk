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

import cn.felord.payment.wechat.enumeration.TradeState;
import cn.felord.payment.wechat.enumeration.TradeType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 支付订单详情
 *
 * @author felord.cn
 * @since 2024/8/17 13:35
 */
@Data
public class PayDetailResponse {
    private String appid;
    private String mchid;
    /**
     * 商户系统内部订单号
     */
    private String outTradeNo;
    /**
     * 微信支付系统生成的订单号
     */
    private String transactionId;
    /**
     * 交易类型
     */
    private TradeType tradeType;
    /**
     * 交易状态
     */
    private TradeState tradeState;
    /**
     * 交易状态描述
     */
    private String tradeStateDesc;
    /**
     * 付款银行
     */
    private String bankType;
    /**
     * 附加数据
     */
    private String attach;
    /**
     * 支付完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime successTime;
    /**
     * 支付者信息
     */
    private Payer payer;
    /**
     * 订单金额信息，当支付成功时返回该字段
     */
    private PayOrderAmount amount;
    /**
     * 场景信息
     */
    private SimpleSceneInfo sceneInfo;
    /**
     * 优惠功能，享受优惠时返回该字段
     */
    private List<PromotionInfo> promotionDetail;

}
