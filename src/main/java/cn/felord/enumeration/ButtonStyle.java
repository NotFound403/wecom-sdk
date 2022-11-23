package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Button style.
 *
 * @author dax
 * @since 2021 /9/8 11:14
 */
public enum ButtonStyle {
    /**
     * Primary button style.
     */
    PRIMARY(1),
    /**
     * Default button style.
     */
    DEFAULT(2),
    /**
     * Danger button style.
     */
    DANGER(3),
    /**
     * Text button style.
     */
    TEXT(4);

    private final int style;

    ButtonStyle(int style) {

        this.style = style;
    }

    /**
     * Gets style.
     *
     * @return the style
     */
    @JsonValue
    public int getStyle() {
        return style;
    }

    /**
     * Deserialize button style.
     *
     * @param style the style
     * @return the button style
     */
    @JsonCreator
    public static ButtonStyle deserialize(int style) {
        return Arrays.stream(ButtonStyle.values())
                .filter(multiStyle -> multiStyle.style == style)
                .findFirst()
                .orElse(null);
    }
}
