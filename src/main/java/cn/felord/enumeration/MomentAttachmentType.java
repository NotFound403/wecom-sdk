package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The MomentAttachmentType.
 *
 * @author dax
 * @since 2021/9/9 9:22
 */
public enum MomentAttachmentType {
    /**
     * Image moment attachment type.
     */
    IMAGE("image"),
    /**
     * Video moment attachment type.
     */
    VIDEO("video"),
    /**
     * Link moment attachment type.
     */
    LINK("link");

    private final String type;

    MomentAttachmentType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }

    /**
     * Deserialize add ways.
     *
     * @param type the type
     * @return the add ways
     */
    @JsonCreator
    public static MomentAttachmentType deserialize(String type) {
        return Arrays.stream(MomentAttachmentType.values())
                .filter(contactType -> contactType.type.equals(type))
                .findFirst()
                .orElse(null);
    }
}
