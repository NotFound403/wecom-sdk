package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Chat type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum FormOperType {
    /**
     * Single chat type.
     */
    QUESTION(1),
    /**
     * Group chat type.
     */
    SETTING(2);

    private final int type;

    FormOperType(int type) {
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
     * Deserialize chat type.
     *
     * @param type the type
     * @return the chat type
     */
    @JsonCreator
    public static FormOperType deserialize(int type) {
        return Arrays.stream(FormOperType.values())
                .filter(formOperType -> type == formOperType.type)
                .findFirst()
                .orElse(null);
    }

}
