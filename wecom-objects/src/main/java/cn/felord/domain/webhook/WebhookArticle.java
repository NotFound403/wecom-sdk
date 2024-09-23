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

package cn.felord.domain.webhook;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The type Webhook article.
 *
 * @author dax
 * @since 2024/10/6
 */
@ToString
@Getter
@RequiredArgsConstructor
public class WebhookArticle {
    private final String title;
    private final String url;
    private String description;
    private String picurl;

    /**
     * Description webhook article.
     *
     * @param description the description
     * @return the webhook article
     */
    public WebhookArticle description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Picurl webhook article.
     *
     * @param picurl the picurl
     * @return the webhook article
     */
    public WebhookArticle picurl(String picurl) {
        this.picurl = picurl;
        return this;
    }
}
