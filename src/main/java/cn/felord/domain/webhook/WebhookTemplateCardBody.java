/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.domain.webhook;

import cn.felord.domain.webhook.card.TemplateCard;
import cn.felord.enumeration.HookMsgType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class WebhookTemplateCardBody extends WebhookBody {
    private final TemplateCard templateCard;

    /**
     * Instantiates a new Webhook template card body.
     *
     * @param <T>          the type parameter
     * @param templateCard the template card
     */
    public <T extends TemplateCard> WebhookTemplateCardBody(T templateCard) {
        super(HookMsgType.TEMPLATE_CARD);
        this.templateCard = templateCard;
    }
}
