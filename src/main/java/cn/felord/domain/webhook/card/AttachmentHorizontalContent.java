package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * The type Attachment horizontal content.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:31
 */
@Getter
public class AttachmentHorizontalContent extends HorizontalContent {
    private final String mediaId;

    /**
     * Instantiates a new Attachment horizontal content.
     *
     * @param keyname the keyname
     * @param mediaId the media id
     */
    public AttachmentHorizontalContent(String keyname, String mediaId) {
        this(keyname, mediaId, null);
    }

    /**
     * Instantiates a new Attachment horizontal content.
     *
     * @param keyname the keyname
     * @param mediaId the media id
     * @param value   the value
     */
    public AttachmentHorizontalContent(String keyname, String mediaId, String value) {
        super(HorizontalContentType.ATTACHMENT, keyname, value);
        this.mediaId = mediaId;
    }
}
