package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

/**
 * The enum Chat type.
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum ChatType {
    /**
     * Single chat type.
     */
    SINGLE("single"),
    /**
     * Group chat type.
     */
    GROUP("group");

    private final String type;

    ChatType(String type) {
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
     * Deserialize chat type.
     *
     * @param type the type
     * @return the chat type
     */
    @JsonCreator
    public static ChatType deserialize(String type) {
        return Arrays.stream(ChatType.values())
                .filter(contactType -> Objects.equals(type,contactType.type))
                .findFirst()
                .orElse(null);
    }

}
