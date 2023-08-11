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
 * 直连商户-请求分账回退API-请求参数
 *
 * @author felord.cn
 * @since 1.0.11.RELEASE
 */
@Data
public class ReturnOrdersParams {
    /**
     * 微信分账单号，同{@link #outOrderNo} 二选一
     */
    private String orderId;
    /**
     * 商户分账单号，同{@link #orderId} 二选一
     */
    private String outOrderNo;
    /**
     * 商户回退单号，必填
     */
    private String outReturnNo;
    /**
     * 回退商户号，必填
     * <p>
     * 分账回退的出资商户，只能对原分账请求中成功分给商户接收方进行回退
     */
    private String returnMchid;
    /**
     * 回退金额，必填
     * <p>
     * 需要从分账接收方回退的金额，单位为分，只能为整数，不能超过原始分账单分出给该接收方的金额
     */
    private Integer amount;
    /**
     * 回退描述，必填
     */
    private String description;
}