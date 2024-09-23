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

package cn.felord.mp.enumeration;

/**
 * 卡券状态
 *
 * @author dax
 * @since 2024/8/19
 */
public enum CardStatus {

    /**
     * 待审核
     */
    CARD_STATUS_NOT_VERIFY,
    /**
     * 审核失败
     */
    CARD_STATUS_VERIFY_FAIL,
    /**
     * 通过审核
     */
    CARD_STATUS_VERIFY_OK,
    /**
     * 卡券被商户删除
     */
    CARD_STATUS_DELETE,
    /**
     * 在公众平台投放过的卡券
     */
    CARD_STATUS_DISPATCH
}
