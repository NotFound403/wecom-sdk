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

import cn.felord.domain.webhook.card.NewsTemplateCard;
import cn.felord.domain.webhook.card.TemplateCard;
import cn.felord.domain.webhook.card.TextTemplateCard;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 模板卡片消息
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class WebhookTemplateCardBody extends WebhookBody {
    private final TemplateCard templateCard;

    /**
     * Instantiates a new Webhook template card body.
     *
     * @param templateCard the template card
     * @param <T>          TemplateCard
     */
    public <T extends TemplateCard> WebhookTemplateCardBody(T templateCard) {
        super("template_card");
        this.templateCard = templateCard;
    }

    /**
     * 图文展示模版卡片
     *
     * @param newsTemplateCard the news template card
     * @return the webhook template card body
     */
    public static WebhookTemplateCardBody from(NewsTemplateCard newsTemplateCard) {
        return new WebhookTemplateCardBody(newsTemplateCard);
    }

    /**
     * 文本通知模版卡片
     *
     * @param textTemplateCard the text template card
     * @return the webhook template card body
     */
    public static WebhookTemplateCardBody from(TextTemplateCard textTemplateCard) {
        return new WebhookTemplateCardBody(textTemplateCard);
    }
}
