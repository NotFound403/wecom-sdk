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
 * @author dax
 * @since 2023/7/7 8:54
 */
public enum RefundResult {
    /**
     * 退款成功
     */
    SUCCESS,
    /**
     * 退款关闭
     */
    CLOSE,
    /**
     * 退款处理中
     */
    PROCESSING,
    /**
     * 退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败
     */
    ABNORMAL
}
