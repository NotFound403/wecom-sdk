package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author dax
 * @since 2023/8/4 14:06
 */
public enum DistanceType {
    /**
     * 当前位置
     */
    CURRENT(0),
    /**
     * 附近100米
     */
    CURRENT100(1),
    /**
     * 附近200米
     */
    CURRENT200(2),
    /**
     * 附近300米
     */
    CURRENT300(3);

    private final int type;

    DistanceType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DistanceType
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static DistanceType deserialize(int type) {
        return Arrays.stream(DistanceType.values())
                .filter(distanceType -> distanceType.type == type)
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
