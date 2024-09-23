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

package cn.felord.domain.message;

import lombok.Getter;
import lombok.ToString;

/**
 * @author felord
 * @since 2021/11/22 17:14
 */
@ToString
@Getter
public class MessageTextCard {
    private final String title;
    private final String description;
    private final String url;
    private final String btntxt;

    public MessageTextCard(String title, String description, String url) {
        this(title, description, url, null);
    }

    public MessageTextCard(String title, String description, String url, String btntxt) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.btntxt = btntxt;
    }
}
