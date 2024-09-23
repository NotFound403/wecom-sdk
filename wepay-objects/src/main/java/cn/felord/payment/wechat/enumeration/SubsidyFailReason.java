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

package cn.felord.payment.wechat.enumeration;

/**
 * The enum Subsidy fail reason.
 *
 * @author dax
 * @since 2024/8/25
 */
public enum SubsidyFailReason {
    /**
     * 扣款商户余额不足
     */
    INSUFFICIENT_BALANCE,
    /**
     * 非分账订单
     */
    NOT_INCOMESPLIT_ORDER,
    /**
     * 超出订单补差总额限制
     */
    EXCEED_SUBSIDY_AMOUNT_QUOTA,
    /**
     * 超出订单补差总数限制
     */
    EXCEED_SUBSIDY_COUNT_QUOTA,
    /**
     * 其他原因
     */
    OTHER,
}
