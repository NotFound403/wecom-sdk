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

package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Collections;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/22 15:10
 */
@Getter
public class MomentBody<T extends MomentAttachment> {
    private final VisibleRange visibleRange;
    private ContentText text;
    private Set<T> attachments;

    protected MomentBody(VisibleRange visibleRange) {
        this.visibleRange = visibleRange;
    }

    public static MomentBody<MomentAttachment> textMoment(ContentText text, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> momentAttachmentMomentBody = new MomentBody<>(visibleRange);
        momentAttachmentMomentBody.setText(text);
        return momentAttachmentMomentBody;
    }

    public static MomentBody<ImageMomentAttachment> imageMoment(Set<ImageMomentAttachment> attachments, VisibleRange visibleRange) {
        MomentBody<ImageMomentAttachment> imageMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        imageMomentAttachmentMomentBody.setAttachments(attachments);
        return imageMomentAttachmentMomentBody;
    }

    public static MomentBody<VideoMomentAttachment> videoMoment(VideoMomentAttachment attachment, VisibleRange visibleRange) {
        MomentBody<VideoMomentAttachment> videoMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        videoMomentAttachmentMomentBody.setAttachments(Collections.singleton(attachment));
        return videoMomentAttachmentMomentBody;
    }

    public static MomentBody<LinkMomentAttachment> linkMoment(LinkMomentAttachment attachment, VisibleRange visibleRange) {
        MomentBody<LinkMomentAttachment> linkMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        linkMomentAttachmentMomentBody.setAttachments(Collections.singleton(attachment));
        return linkMomentAttachmentMomentBody;
    }

    public void setText(ContentText text) {
        this.text = text;
    }

    private void setAttachments(Set<T> attachments) {
        this.attachments = attachments;
    }
}
