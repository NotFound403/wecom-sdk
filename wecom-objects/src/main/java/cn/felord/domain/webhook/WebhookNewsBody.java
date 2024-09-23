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

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 图文消息
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class WebhookNewsBody extends WebhookBody {
    private final WebhookNews news;

    /**
     * Instantiates a new Webhook news body.
     *
     * @param news the news
     */
    WebhookNewsBody(WebhookNews news) {
        super("news");
        this.news = news;
    }

    /**
     * From webhook news body.
     *
     * @param articles the articles
     * @return the webhook news body
     */
    public static WebhookNewsBody from(List<WebhookArticle> articles) {
        return new WebhookNewsBody(new WebhookNews(articles));
    }


    /**
     * The type Webhook news.
     */
    @ToString
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class WebhookNews {
        private final List<WebhookArticle> articles;
    }

}
