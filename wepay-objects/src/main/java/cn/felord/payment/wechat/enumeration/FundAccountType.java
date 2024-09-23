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
 * 优惠类型
 *
 * @author felord.cn
 * @since 2024/8/17 13:53
 */
public enum FundAccountType {

    /**
     * 未结算资金
     */
    UNSETTLED,
    /**
     * 可用余额
     */
    AVAILABLE,
    /**
     * 不可用余额
     */
    UNAVAILABLE,
    /**
     * 运营户
     */
    OPERATION,
    /**
     * 基本账户（含可用余额和不可用余额）
     */
    BASIC
}
