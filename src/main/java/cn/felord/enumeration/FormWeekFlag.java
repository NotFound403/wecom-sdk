package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Fill out auth.
 *
 * @author dax
 * @since 2023 /3/13 17:05
 */
public enum FormWeekFlag {


    /**
     * Mon form week flag.
     */
    MON(1),
    /**
     * Tues form week flag.
     */
    TUES(2),
    /**
     * Wed form week flag.
     */
    WED(4),
    /**
     * Thur form week flag.
     */
    THUR(8),
    /**
     * Fri form week flag.
     */
    FRI(16),
    /**
     * Sat form week flag.
     */
    SAT(32),
    /**
     * Sun form week flag.
     */
    SUN(64);

    private final int type;

    FormWeekFlag(int type) {
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
     * Deserialize fill out auth.
     *
     * @param type the type
     * @return the fill out auth
     */
    @JsonCreator
    public static FormWeekFlag deserialize(int type) {
        return Arrays.stream(FormWeekFlag.values())
                .filter(formWeekFlag -> formWeekFlag.type == type)
                .findFirst()
                .orElse(null);
    }

}
