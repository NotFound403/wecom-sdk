package cn.felord.domain.webhook.card;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Horizontal content type.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:16
 */
enum HorizontalContentType {
    /**
     * Text.
     */
    TEXT(0),
    /**
     * Url.
     */
    URL(1),
    /**
     * Attachment.
     */
    ATTACHMENT(2),
    /**
     * At staff.
     */
    AT_STAFF(3);

    private final int type;

    HorizontalContentType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }
}
