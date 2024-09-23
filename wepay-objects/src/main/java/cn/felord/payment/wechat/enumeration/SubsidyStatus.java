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
 * The enum Subsidy status.
 *
 * @author dax
 * @since 2024/8/25
 */
public enum SubsidyStatus {
    /**
     * 受理成功
     */
    ACCEPTED,
    /**
     * 补差补款成功
     */
    SUCCESS,
    /**
     * 补差付款失败
     */
    FAIL,
    /**
     * 补差回退中
     */
    RETURNING,
    /**
     * 补差部分回退
     */
    PARTIAL_RETURN,
    /**
     * 补差全额回退
     */
    FULL_RETURN,
}
