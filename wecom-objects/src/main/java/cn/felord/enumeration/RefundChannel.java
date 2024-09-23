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

package cn.felord.enumeration;

/**
 * @author dax
 * @since 2023/7/7 8:51
 */
public enum RefundChannel {

    /**
     * 原路退款
     */
    ORIGINAL,

    /**
     * 退回到余额
     */
    BALANCE,

    /**
     * 原账户异常退到其他余额账户
     */
    OTHER_BALANCE,

    /**
     * 原银行卡异常退到其他银行卡
     */
    OTHER_BANKCARD
}
