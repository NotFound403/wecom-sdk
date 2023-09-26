package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Day data type.
 *
 * @author dax
 * @since 2023 /9/26
 */
public enum DayDataType {
    /**
     * 工作日日报
     */
    WEEKDAY(0),
    /**
     * 休息日日报
     */
    HOLIDAY(1);

    private final int type;

    DayDataType(int type) {
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
     * Deserialize DayDataType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static DayDataType deserialize(int type) {
        return Arrays.stream(DayDataType.values())
                .filter(dayDataType -> dayDataType.type == type)
                .findFirst()
                .orElse(null);
    }
}
