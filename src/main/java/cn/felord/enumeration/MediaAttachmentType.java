package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Attachment type.
 *
 * @author dax
 * @since 2021/5/11 19:32
 */
public enum MediaAttachmentType {
    /**
     * Moment attachment type.
     */
    MOMENT(1),
    /**
     * Product album attachment type.
     */
    PRODUCT_ALBUM(2);

    private final int type;

    MediaAttachmentType(int type) {
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

    /**
     * Deserialize attachment type.
     *
     * @param type the type
     * @return the attachment type
     */
    @JsonCreator
    public static MediaAttachmentType deserialize(int type) {
        return Arrays.stream(MediaAttachmentType.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }

}
