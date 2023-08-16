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

package cn.felord.payment.wechat.v3.domain.model.profitsharing;

import lombok.Data;

/**
 * 直连商户-解冻剩余资金API-请求参数
 *
 * @author felord.cn
 * @since 1.0.11.RELEASE
 */
@Data
public class UnfreezeParams {
    /**
     * 微信订单号，必填
     */
    private String transactionId;
    /**
     * 商户分账单号，必填
     */
    private String outOrderNo;
    /**
     * 分账描述，必填
     */
    private String description;
}