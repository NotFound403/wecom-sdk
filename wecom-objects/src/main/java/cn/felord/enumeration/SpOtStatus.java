package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2023/9/26
 */
public enum SpOtStatus {

    /**
     * 无加班
     */
    NO_OVERTIME(0),
    /**
     * 正常
     */
    NORMAL(1),

    /**
     * 缺时长
     */
    LACK(2);

    private final int status;

    SpOtStatus(int status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @JsonValue
    public int getStatus() {
        return status;
    }

    /**
     * Deserialize SpOtStatus
     *
     * @param status the status
     * @return the RefundStatus
     */
    @JsonCreator
    public static SpOtStatus deserialize(int status) {
        return Arrays.stream(SpOtStatus.values())
                .filter(spOtStatus -> spOtStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
