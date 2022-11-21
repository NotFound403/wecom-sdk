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
public enum ScheduleOpMode {
    /**
     * All schedule op mode.
     */
    ALL(0),
    /**
     * This schedule op mode.
     */
    THIS(1),
    /**
     * Future schedule op mode.
     */
    FUTURE(2);

    private final int mode;

    ScheduleOpMode(int mode) {
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
    public static ScheduleOpMode deserialize(int mode) {
        return Arrays.stream(ScheduleOpMode.values())
                .filter(contactScene -> contactScene.mode == mode)
                .findFirst()
                .orElse(null);
    }
}
