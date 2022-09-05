package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:31
 */
@Getter
public class AttachmentHorizontalContent extends HorizontalContent {
    private final String mediaId;
    public AttachmentHorizontalContent(String keyname, String mediaId) {
        super(HorizontalContentType.ATTACHMENT, keyname);
        this.mediaId = mediaId;
    }
}
