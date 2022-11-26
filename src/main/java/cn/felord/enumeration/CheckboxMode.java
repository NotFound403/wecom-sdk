package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Schedule op mode.
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum CheckboxMode {

    /**
     * Single checkbox mode.
     */
    SINGLE(0),

    /**
     * Multi checkbox mode.
     */
    MULTI(1);

    private final int mode;

    CheckboxMode(int mode) {
        this.mode = mode;
    }

    /**
     * Gets mode.
     *
     * @return the mode
     */
    @JsonValue
    public int getMode() {
        return mode;
    }

    /**
     * Deserialize schedule op mode.
     *
     * @param mode the mode
     * @return the schedule op mode
     */
    @JsonCreator
    public static CheckboxMode deserialize(int mode) {
        return Arrays.stream(CheckboxMode.values())
                .filter(contactScene -> contactScene.mode == mode)
                .findFirst()
                .orElse(null);
    }
}
