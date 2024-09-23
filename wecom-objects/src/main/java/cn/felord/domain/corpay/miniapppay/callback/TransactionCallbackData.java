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
package cn.felord.domain.corpay.miniapppay.callback;

import cn.felord.domain.corpay.miniapppay.OrderAmount;
import cn.felord.domain.corpay.miniapppay.Payer;
import cn.felord.domain.corpay.miniapppay.PromotionDetail;
import cn.felord.enumeration.MiniPayTradeState;
import cn.felord.enumeration.MiniPayTradeType;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 支付成功通知解密
 *
 * @author dax
 * @since 1.1.2
 */
@Data
public class TransactionCallbackData {

    /**
     * 直连模式应用ID
     */
    private String appid;
    /**
     * 直连模式商户号
     */
    private String mchid;
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 交易状态
     */
    private MiniPayTradeState tradeState;
    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private String attach;
    /**
     * 支付完成时间
     */
    private OffsetDateTime successTime;
    /**
     * 订单金额
     */
    private OrderAmount amount;
    /**
     * 银行类型，采用字符串类型的银行标识。银行标识请参考 <a target= "_blank" href= "https://pay.weixin.qq.com/wiki/doc/apiv3/terms_definition/chapter1_1_3.shtml#part-6">《银行类型对照表》</a>
     */
    private String bankType;
    /**
     * 支付者信息
     */
    private Payer payer;
    /**
     * 优惠功能，享受优惠时返回该字段。
     */
    private List<PromotionDetail> promotionDetail;
    /**
     * 交易状态描述
     */
    private String tradeStateDesc;
    /**
     * 交易类型
     */
    private MiniPayTradeType tradeType;
    /**
     * 微信支付订单号
     */
    private String transactionId;

}
