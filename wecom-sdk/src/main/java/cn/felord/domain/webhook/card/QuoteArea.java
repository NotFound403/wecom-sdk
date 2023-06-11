/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.Setter;

/**
 * 引用文献样式，建议不与关键数据共用
 *
 * @author felord.cn
 * @since 2021/9/3 14:36
 */
@Getter
@Setter
public abstract class QuoteArea {
    private final ClickEventType type;

    protected QuoteArea(ClickEventType type) {
        this.type = type;
    }

    private String title;
    private String quoteText;
}
