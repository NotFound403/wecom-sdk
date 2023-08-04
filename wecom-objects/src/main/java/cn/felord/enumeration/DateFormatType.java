package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2023/8/4 14:28
 */
public enum DateFormatType {
    /**
     * 年/月/日/时/分
     */
    YMDHM(0),
    /**
     * 年/月/日
     */
    YMD(1),
    /**
     * 年/月
     */
    YM(2);

    private final int type;

    DateFormatType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DateFormatType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static DateFormatType deserialize(int type) {
        return Arrays.stream(DateFormatType.values())
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
