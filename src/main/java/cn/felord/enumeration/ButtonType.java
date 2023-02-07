package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Button type.
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum ButtonType {
    /**
     * Callback button type.
     */
    CALLBACK(0),
    /**
     * Redirect button type.
     */
    REDIRECT(1);

    private final int type;

    ButtonType(int type) {
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
    public static ButtonType deserialize(int type) {
        return Arrays.stream(ButtonType.values())
                .filter(contactScene -> contactScene.type == type)
                .findFirst()
                .orElse(null);
    }
}
