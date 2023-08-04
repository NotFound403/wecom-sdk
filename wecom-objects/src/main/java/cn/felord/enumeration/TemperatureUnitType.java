package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 温度单位
 *
 * @author dax
 * @since 2023 /8/4 14:28
 */
public enum TemperatureUnitType {
    /**
     * 摄氏度
     */
    CELSIUS(0),
    /**
     * 华氏度
     */
    FAHRENHEIT(1);

    private final int type;

    TemperatureUnitType(int type) {
        this.type = type;
    }

    /**
     * Deserialize TemperatureUnitType
     *
     * @param type the type
     * @return the TemperatureUnitType
     */
    @JsonCreator
    public static TemperatureUnitType deserialize(int type) {
        return Arrays.stream(TemperatureUnitType.values())
                .filter(temperatureUnitType -> temperatureUnitType.type == type)
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
