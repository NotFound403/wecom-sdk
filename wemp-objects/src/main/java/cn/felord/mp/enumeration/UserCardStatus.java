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
 * 当前code对应卡券的状态
 * <p>
 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
 *
 * @author dax
 * @since 2024/8/19
 */
public enum UserCardStatus {
    /**
     * 正常
     */
    NORMAL,
    /**
     * 已核销
     */
    CONSUMED,
    /**
     * 已过期
     */
    EXPIRE,
    /**
     * 转赠中
     */
    GIFTING,
    /**
     * 转赠成功
     */
    GIFT_SUCC,
    /**
     * 转赠超时
     */
    GIFT_TIMEOUT,
    /**
     * 已删除
     */
    DELETE,
    /**
     * 已失效
     */
    UNAVAILABLE
}
