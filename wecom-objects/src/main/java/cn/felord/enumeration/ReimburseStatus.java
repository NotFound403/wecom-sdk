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
 * 发报销状态
 *
 * @author dax
 * @since 2024/6/25 15:26
 */
public enum ReimburseStatus {

    /**
     * 发票初始状态,未锁定
     */
    INVOICE_REIMBURSE_INIT,
    /**
     * 发票已锁定
     */
    INVOICE_REIMBURSE_LOCK,
    /**
     * 发票已核销
     */
    INVOICE_REIMBURSE_CLOSURE
}
