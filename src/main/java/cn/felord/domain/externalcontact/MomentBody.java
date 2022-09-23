package cn.felord.domain.externalcontact;

import java.util.Collections;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/22 15:10
 */
public class MomentBody<T extends MomentAttachment> {
    private Text text;
    private Set<T> attachments;
    private VisibleRange visibleRange;

    MomentBody() {
    }

    public MomentBody(Text text) {
        this.text = text;
    }

    public static MomentBody<MomentAttachment> textMoment(Text text) {
        return new MomentBody<>(text);
    }

    public static MomentBody<ImageMomentAttachment> imageMoment(Set<ImageMomentAttachment> attachments) {
        MomentBody<ImageMomentAttachment> imageMomentAttachmentMomentBody = new MomentBody<>();
        imageMomentAttachmentMomentBody.setAttachments(attachments);
        return imageMomentAttachmentMomentBody;
    }

    public static MomentBody<VideoMomentAttachment> videoMoment(VideoMomentAttachment attachment) {
        MomentBody<VideoMomentAttachment> videoMomentAttachmentMomentBody = new MomentBody<>();
        videoMomentAttachmentMomentBody.setAttachments(Collections.singleton(attachment));
        return videoMomentAttachmentMomentBody;
    }

    public static MomentBody<LinkMomentAttachment> linkMoment(LinkMomentAttachment attachment) {
        MomentBody<LinkMomentAttachment> linkMomentAttachmentMomentBody = new MomentBody<>();
        linkMomentAttachmentMomentBody.setAttachments(Collections.singleton(attachment));
        return linkMomentAttachmentMomentBody;
    }

    public void setText(Text text) {
        this.text = text;
    }

    void setAttachments(Set<T> attachments) {
        this.attachments = attachments;
    }

    public void setVisibleRange(VisibleRange visibleRange) {
        this.visibleRange = visibleRange;
    }

    public Text getText() {
        return text;
    }

    public Set<T> getAttachments() {
        return attachments;
    }

    public VisibleRange getVisibleRange() {
        return visibleRange;
    }
}
