package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The FormItemStatus
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum FormItemStatus {

    /**
     * Normal form item status.
     */
    NORMAL(1),

    /**
     * Deleted form item status.
     */
    DELETED(2);

    private final int type;

    FormItemStatus(int type) {
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
     * Deserialize button type.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static FormItemStatus deserialize(int type) {
        return Arrays.stream(FormItemStatus.values())
                .filter(formItemStatus -> formItemStatus.type == type)
                .findFirst()
                .orElse(null);
    }
}
