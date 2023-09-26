package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Checkin record type.
 *
 * @author dax
 * @since 2023 /9/26
 */
public enum CheckinRecordType {
    /**
     * 固定时间上下班
     */
    REGULARLY(1),
    /**
     * 外出（报表中不会出现外出打卡数据）
     */
    OUT(2),
    /**
     * 自由上下班
     */
    SHIFT(3),
    /**
     * 自由签到
     */
    FREE(4),
    /**
     * 加班
     */
    OVERTIME(5),
    /**
     * 无规则
     */
    NO_RULE(7);

    private final int type;

    CheckinRecordType(int type) {
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
     * Deserialize CheckinRecordType
     *
     * @param type the type
     * @return the checkin data type
     */
    @JsonCreator
    public static CheckinRecordType deserialize(int type) {
        return Arrays.stream(CheckinRecordType.values())
                .filter(checkinRecordType -> checkinRecordType.type == type)
                .findFirst()
                .orElse(null);
    }
}
