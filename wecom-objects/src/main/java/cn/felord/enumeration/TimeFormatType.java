package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2023/8/4 14:28
 */
public enum TimeFormatType {
    /**
     * 时分
     */
    HM(0),
    /**
     * 时分秒
     */
    HMS(1);

    private final int type;

    TimeFormatType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DateFormatType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static TimeFormatType deserialize(int type) {
        return Arrays.stream(TimeFormatType.values())
                .filter(dateFormatType -> dateFormatType.type == type)
                .findFirst()
                .orElse(null);
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

}
