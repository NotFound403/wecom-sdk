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
 * The MiniApyBillType
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum MiniApyBillType {
    /**
     * 返回当日所有订单信息（不含充值退款订单）
     */
    ALL,
    /**
     * 返回当日成功支付的订单（不含充值退款订单）
     */
    SUCCESS,
    /**
     * 返回当日退款订单（不含充值退款订单）
     */
    REFUND
}
