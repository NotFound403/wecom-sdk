package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Msg origin.
 *
 * @author n1
 * @since 2021 /6/16 14:39
 */
public enum KfMsgOrigin {

    /**
     * Wechat customer kf msg origin.
     */
    WECHAT_CUSTOMER(3),
    /**
     * System kf msg origin.
     */
    SYSTEM(4),
    /**
     * Work wechat servicer kf msg origin.
     */
    WORK_WECHAT_SERVICER(5);

    private final int origin;

    KfMsgOrigin(int origin) {
        this.origin = origin;
    }

    /**
     * Gets origin.
     *
     * @return the origin
     */
    @JsonValue
    public int getOrigin() {
        return origin;
    }

    /**
     * Deserialize range origin.
     *
     * @param origin the origin
     * @return the range origin
     */
    @JsonCreator
    public static KfMsgOrigin deserialize(int origin) {
        return Arrays.stream(KfMsgOrigin.values())
                .filter(kfMsgOrigin -> kfMsgOrigin.origin == origin)
                .findFirst()
                .orElse(null);
    }
}
