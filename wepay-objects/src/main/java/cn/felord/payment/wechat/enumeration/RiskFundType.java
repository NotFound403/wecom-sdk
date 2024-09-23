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
 * 风险金类型
 *
 * @author dax
 * @since 2023/8/22
 */
public enum RiskFundType {
    /**
     * 押金
     */
    DEPOSIT,
    /**
     * 预付款
     */
    ADVANCE,
    /**
     * 保证金
     */
    CASH_DEPOSIT,
    /**
     * 预估订单费用
     * <p>
     * 【先享模式】（评估不通过不可使用服务）
     */
    ESTIMATE_ORDER_COST
}
