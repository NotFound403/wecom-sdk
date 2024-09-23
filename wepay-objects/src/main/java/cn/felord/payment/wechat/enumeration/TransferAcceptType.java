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
 * 批量转账到零钱 - 电子回单受理类型
 *
 * @author felord.cn
 * @since 1.0.11.RELEASE
 */
public enum TransferAcceptType {
    /**
     * 批量转账明细电子回单
     */
    BATCH_TRANSFER,
    /**
     * 企业付款至零钱电子回单
     */
    TRANSFER_TO_POCKET,
    /**
     * 企业付款至银行卡电子回单
     */
    TRANSFER_TO_BANK
}
