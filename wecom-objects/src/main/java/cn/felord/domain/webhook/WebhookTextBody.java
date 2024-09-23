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
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 文本消息
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class WebhookTextBody extends WebhookBody {
    private final WebhookText text;

    /**
     * Instantiates a new Webhook text body.
     *
     * @param text the text
     */
    WebhookTextBody(WebhookText text) {
        super("text");
        this.text = text;
    }

    /**
     * From webhook text body.
     *
     * @param content the content
     * @return the webhook text body
     */
    public static WebhookTextBody from(String content) {
        return from(content, null);
    }

    /**
     * From webhook text body.
     *
     * @param content       the content
     * @param mentionedList the mentioned list
     * @return the webhook text body
     */
    public static WebhookTextBody from(String content, List<String> mentionedList) {
        return from(content, mentionedList, null);
    }

    /**
     * From webhook text body.
     *
     * @param content             the content
     * @param mentionedList       the mentioned list
     * @param mentionedMobileList the mentioned mobile list
     * @return the webhook text body
     */
    public static WebhookTextBody from(String content, List<String> mentionedList, List<String> mentionedMobileList) {
        WebhookText webhookText = new WebhookText(content);
        webhookText.setMentionedList(mentionedList);
        webhookText.setMentionedMobileList(mentionedMobileList);
        return new WebhookTextBody(webhookText);
    }

    /**
     * The type Text.
     */
    @ToString
    @Getter
    @Setter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public static class WebhookText {
        private final String content;
        private List<String> mentionedList;
        private List<String> mentionedMobileList;
    }

}
