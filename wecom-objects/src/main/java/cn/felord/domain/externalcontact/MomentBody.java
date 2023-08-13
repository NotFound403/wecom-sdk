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

package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dax
 * @since 2021/7/22 15:10
 */
@Getter
public class MomentBody<T extends MomentAttachment> {
    private final VisibleRange visibleRange;
    private ContentText text;
    private Set<T> attachments;

    MomentBody(VisibleRange visibleRange) {
        this.visibleRange = visibleRange;
    }

    public static MomentBody<MomentAttachment> textMoment(String content, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> momentAttachmentMomentBody = new MomentBody<>(visibleRange);
        momentAttachmentMomentBody.setText(new ContentText(content));
        return momentAttachmentMomentBody;
    }

    public static MomentBody<MomentAttachment> imageMoment(Set<String> imageMediaIds, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> imageMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        Set<MomentAttachment> momentAttachments = imageMediaIds.stream()
                .map(ImageMomentAttachment::new)
                .collect(Collectors.toSet());
        imageMomentAttachmentMomentBody.setAttachments(momentAttachments);
        return imageMomentAttachmentMomentBody;
    }

    public static MomentBody<MomentAttachment> videoMoment(String videoMediaId, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> videoMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        videoMomentAttachmentMomentBody.setAttachments(Collections.singleton(new VideoMomentAttachment(videoMediaId)));
        return videoMomentAttachmentMomentBody;
    }

    public static MomentBody<MomentAttachment> linkMoment(MomentLink momentLink, VisibleRange visibleRange) {
        MomentBody<MomentAttachment> linkMomentAttachmentMomentBody = new MomentBody<>(visibleRange);
        linkMomentAttachmentMomentBody.setAttachments(Collections.singleton(new LinkMomentAttachment(momentLink)));
        return linkMomentAttachmentMomentBody;
    }

    public void setText(ContentText text) {
        this.text = text;
    }

    private void setAttachments(Set<T> attachments) {
        this.attachments = attachments;
    }
}
