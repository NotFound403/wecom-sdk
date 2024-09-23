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

import lombok.Data;

/**
 * 订单金额信息
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class PayOrderAmount {
    /**
     * 金额，单位【分】。
     */
    private Long total;
    /**
     * 用户支付金额，单位为分。（指使用优惠券的情况下，这里等于总金额-优惠券金额）
     */
    private Long payerTotal;
    /**
     * 货币单位，固定为 CNY 。
     */
    private String currency;
    /**
     * 用户支付币种
     */
    private String payerCurrency;

}
