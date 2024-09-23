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

package cn.felord.domain.externalcontact;

import cn.felord.utils.StringUtils;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Moment body.
 *
 * @param <T> the type parameter
 * @author dax
 * @since 2021 /7/22 15:10
 */
@ToString
@Getter
public class MomentBody<T extends MomentAttachment> {
    private final VisibleRange visibleRange;
    private ContentText text;
    private Set<T> attachments;

    /**
     * Instantiates a new Moment body.
     *
     * @param visibleRange the visible range
     */
    MomentBody(VisibleRange visibleRange) {
        this.visibleRange = visibleRange;
    }

    /**
     * 纯文本朋友圈，全员发送
     *
     * @param content the content
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> textMoment(String content) {
        return textMoment(content, null);
    }

    /**
     * 纯文本朋友圈，不带附件，指定发送范围
     *
     * @param content      the content
     * @param visibleRange the visible range
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> textMoment(String content, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> momentAttachmentMomentBody = new MomentBody<>(visibleRange);
        momentAttachmentMomentBody.setText(new ContentText(content));
        return momentAttachmentMomentBody;
    }

    /**
     * 图片附件朋友圈，不带文案，全员发送
     *
     * @param imageMediaIds the image media ids
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> imageMoment(Set<String> imageMediaIds) {
        return imageMoment(imageMediaIds, null);
    }

    /**
     * 图片附件朋友圈，不带文案，指定范围
     *
     * @param imageMediaIds the image media ids
     * @param visibleRange  the visible range
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> imageMoment(Set<String> imageMediaIds, VisibleRange visibleRange) {
        return imageMoment(null, imageMediaIds, visibleRange);
    }

    /**
     * 图片附件朋友圈，带文案，指定范围
     *
     * @param content       the content
     * @param imageMediaIds the image media ids
     * @param visibleRange  the visible range
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> imageMoment(String content, Set<String> imageMediaIds, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> imageMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        if (StringUtils.hasText(content)) {
            imageMomentAttachmentMomentBody.setText(new ContentText(content));
        }
        Set<MomentAttachment> momentAttachments = imageMediaIds.stream()
                .map(ImageMomentAttachment::new)
                .collect(Collectors.toSet());
        imageMomentAttachmentMomentBody.setAttachments(momentAttachments);
        return imageMomentAttachmentMomentBody;
    }

    /**
     * 视频附件朋友圈，不带文案，全员发送
     *
     * @param videoMediaId the video media id
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> videoMoment(String videoMediaId) {
        return videoMoment(videoMediaId, null);
    }

    /**
     * 视频附件朋友圈，不带文案，指定范围
     *
     * @param videoMediaId the video media id
     * @param visibleRange the visible range
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> videoMoment(String videoMediaId, VisibleRange visibleRange) {
        return videoMoment(null, videoMediaId, visibleRange);
    }

    /**
     * 视频附件朋友圈
     *
     * @param content      the content
     * @param videoMediaId the video media id
     * @param visibleRange the visible range
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> videoMoment(String content, String videoMediaId, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> videoMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        if (StringUtils.hasText(content)) {
            videoMomentAttachmentMomentBody.setText(new ContentText(content));
        }
        videoMomentAttachmentMomentBody.setAttachments(Collections.singleton(new VideoMomentAttachment(videoMediaId)));
        return videoMomentAttachmentMomentBody;
    }

    /**
     * 图文附件朋友圈，不带文案，全员发送
     *
     * @param linkMomentAttachment the link moment attachment
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> linkMoment(LinkMomentAttachment linkMomentAttachment) {
        return linkMoment(linkMomentAttachment, null);
    }

    /**
     * 图文附件朋友圈，不带文案，指定范围
     *
     * @param linkMomentAttachment the link moment attachment
     * @param visibleRange         the visible range
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> linkMoment(LinkMomentAttachment linkMomentAttachment, VisibleRange visibleRange) {
        return linkMoment(null, linkMomentAttachment, visibleRange);
    }

    /**
     * 图文附件朋友圈
     *
     * @param content              the content
     * @param linkMomentAttachment the link moment attachment
     * @param visibleRange         the visible range
     * @return the moment body
     */
    public static MomentBody<MomentAttachment> linkMoment(String content, LinkMomentAttachment linkMomentAttachment, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> linkMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        if (StringUtils.hasText(content)) {
            linkMomentAttachmentMomentBody.setText(new ContentText(content));
        }
        linkMomentAttachmentMomentBody.setAttachments(Collections.singleton(linkMomentAttachment));
        return linkMomentAttachmentMomentBody;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    private void setText(ContentText text) {
        this.text = text;
    }

    private void setAttachments(Set<T> attachments) {
        this.attachments = attachments;
    }
}
