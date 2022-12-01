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
