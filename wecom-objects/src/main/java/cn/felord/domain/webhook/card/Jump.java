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

import lombok.Getter;

/**
 * 引用文献样式，建议不与关键数据共用
 *
 * @author felord.cn
 * @since 2021/9/3 14:36
 */
@Getter
public abstract class Jump {
    private final ClickEventType type;

    private final String title;

    protected Jump(ClickEventType type, String title) {
        this.type = type;
        this.title = title;
    }

}
