package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 日程提醒
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public enum RemindBeforeEventSecs {


    /**
     * Start remind before event secs.
     */
    START(0),
    /**
     * Five min remind before event secs.
     */
    FIVE_MIN(300),
    /**
     * Fifteen min remind before event secs.
     */
    FIFTEEN_MIN(900),
    /**
     * One hour remind before event secs.
     */
    ONE_HOUR(3600),
    /**
     * One day remind before event secs.
     */
    ONE_DAY(86400);

    private final int sec;

    RemindBeforeEventSecs(int sec) {
        this.sec = sec;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getsec() {
        return sec;
    }

    /**
     * Deserialize bool enum.
     *
     * @param sec the sec
     * @return the bool enum
     */
    @JsonCreator
    public static RemindBeforeEventSecs deserialize(int sec) {
        return Arrays.stream(RemindBeforeEventSecs.values())
                .filter(boolEnum -> boolEnum.sec == sec)
                .findFirst()
                .orElse(null);
    }
}
