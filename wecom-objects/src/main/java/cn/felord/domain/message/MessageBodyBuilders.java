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

import cn.felord.domain.common.MediaId;
import cn.felord.domain.externalcontact.ContentText;

import java.util.List;

/**
 * The type Message body builder.
 *
 * @author dax
 * @since 2021 /11/25
 */
public final class MessageBodyBuilders {

    /**
     * Instantiates a new Message body builder.
     */
    private MessageBodyBuilders() {
    }

    /**
     * 文本消息
     *
     * @param text the text
     * @return the text message body . builder
     */
    public static TextMessageBody.Builder textMessageBodyBuilder(ContentText text) {
        return new TextMessageBody.Builder(text);
    }

    /**
     * 图片消息
     *
     * @param image the image
     * @return the image message body . builder
     */
    public static ImageMessageBody.Builder imageMessageBodyBuilder(MediaId image) {
        return new ImageMessageBody.Builder(image);
    }

    /**
     * 语音消息
     *
     * @param voice the voice
     * @return the voice message body . builder
     */
    public static VoiceMessageBody.Builder voiceMessageBodyBuilder(MediaId voice) {
        return new VoiceMessageBody.Builder(voice);
    }

    /**
     * 视频消息
     *
     * @param video the video
     * @return the voice message body . builder
     */
    public static VideoMessageBody.Builder videoMessageBodyBuilder(MessageVideo video) {
        return new VideoMessageBody.Builder(video);
    }

    /**
     * 文件消息
     *
     * @param file the file
     * @return the file message body . builder
     */
    public static FileMessageBody.Builder fileMessageBodyBuilder(MediaId file) {
        return new FileMessageBody.Builder(file);
    }

    /**
     * 文本卡片消息
     *
     * @param textcard the textcard
     * @return the text card message body . builder
     */
    public static TextCardMessageBody.Builder textCardMessageBodyBuilder(MessageTextCard textcard) {
        return new TextCardMessageBody.Builder(textcard);
    }

    /**
     * 图文消息
     *
     * @param news the news
     * @return the news message body . builder
     */
    @Deprecated
    public static NewsMessageBody.Builder newsMessageBodyBuilder(MessageNews<NewsArticle> news) {
        return new NewsMessageBody.Builder(news);
    }

    /**
     * 图文消息
     *
     * @param news the news
     * @return the news message body . builder
     */
    public static NewsMessageBody.Builder newsMessageBodyBuilder(List<NewsArticle> news) {
        return new NewsMessageBody.Builder(new MessageNews<>(news));
    }

    /**
     * 图文消息（mpnews）
     *
     * @param mpnews the mpnews
     * @return the mp news message body . builder
     */
    @Deprecated
    public static MpNewsMessageBody.Builder mpNewsMessageBodyBuilder(MessageNews<MpNewsArticle> mpnews) {
        return new MpNewsMessageBody.Builder(mpnews);
    }

    /**
     * 图文消息（mpnews）
     *
     * @param mpnews the mpnews
     * @return the mp news message body . builder
     */
    public static MpNewsMessageBody.Builder mpNewsMessageBodyBuilder(List<MpNewsArticle> mpnews) {
        return new MpNewsMessageBody.Builder(new MessageNews<>(mpnews));
    }

    /**
     * markdown消息
     *
     * @param markdown the markdown
     * @return the markdown message body . builder
     */
    public static MarkdownMessageBody.Builder markdownMessageBodyBuilder(ContentText markdown) {
        return new MarkdownMessageBody.Builder(markdown);
    }

    /**
     * 小程序通知消息
     *
     * @param miniprogramNotice the miniprogram notice
     * @return the miniprogram message body . builder
     */
    public static MiniprogramMessageBody.Builder miniprogramMessageBodyBuilder(MiniprogramNotice miniprogramNotice) {
        return new MiniprogramMessageBody.Builder(miniprogramNotice);
    }

    /**
     * 模板卡片消息
     *
     * @param <M>          the type parameter
     * @param templateCard the template card
     * @return the template card message body . builder
     */
    public static <M extends AbstractCard> TemplateCardMessageBody.Builder<M> templateCardMessageBodyBuilder(M templateCard) {
        return new TemplateCardMessageBody.Builder<>(templateCard);
    }
}
