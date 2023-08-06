package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 时间刻度
 *
 * @author dax
 * @since 2023 /8/4 14:28
 */
public enum DurationTimeScale {
    /**
     * 按天
     */
    DAY(1),
    /**
     * 按小时
     */
    HOUR(2);

    private final int scale;

    DurationTimeScale(int scale) {
        this.scale = scale;
    }

    /**
     * Deserialize DurationScale
     *
     * @param scale the scale
     * @return the DurationScale
     */
    @JsonCreator
    public static DurationTimeScale deserialize(int scale) {
        return Arrays.stream(DurationTimeScale.values())
                .filter(durationTimeScale -> durationTimeScale.scale == scale)
                .findFirst()
                .orElse(null);
    }


    /**
     * Gets scale.
     *
     * @return the scale
     */
    @JsonValue
    public int getScale() {
        return scale;
    }

}
