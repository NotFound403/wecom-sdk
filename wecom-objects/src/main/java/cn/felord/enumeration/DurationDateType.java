package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 日期类型
 *
 * @author dax
 * @since 2023 /8/4 14:28
 */
public enum DurationDateType {
    /**
     * 自然日
     */
    NATURAL_DAY(1),
    /**
     * 工作日（跳过双休和法定节假日）
     */
    WORK_DAY(2);

    private final int type;

    DurationDateType(int type) {
        this.type = type;
    }

    /**
     * Deserialize DurationDateType
     *
     * @param type the type
     * @return the DurationDateType
     */
    @JsonCreator
    public static DurationDateType deserialize(int type) {
        return Arrays.stream(DurationDateType.values())
                .filter(durationDateType -> durationDateType.type == type)
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
