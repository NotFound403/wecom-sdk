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

package cn.felord.domain.webhook.card;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 点击事件
 *
 * @author felord.cn
 * @since 2021/9/3 14:37
 */
public enum ClickEventType {
    /**
     * None.
     */
    NONE(0),
    /**
     * Url.
     */
    URL(1),
    /**
     * Miniprogram.
     */
    MINIPROGRAM(2);

    private final int type;

    ClickEventType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }
}
