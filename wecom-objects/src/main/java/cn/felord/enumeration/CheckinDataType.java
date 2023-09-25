package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Checkin data type.
 *
 * @author dax
 * @since 2023 /9/25
 */
public enum CheckinDataType {
    /**
     * 上下班打卡
     */
    WORK(1),
    /**
     * 外出打卡
     */
    OUT(2),
    /**
     * 全部打卡
     */
    BOTH(3);

    private final int type;

    CheckinDataType(int type) {
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
     * Deserialize checkin data type.
     *
     * @param type the type
     * @return the checkin data type
     */
    @JsonCreator
    public static CheckinDataType deserialize(int type) {
        return Arrays.stream(CheckinDataType.values())
                .filter(checkinDataType -> checkinDataType.type == type)
                .findFirst()
                .orElse(null);
    }
}
