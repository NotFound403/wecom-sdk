package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.TemperatureUnitType;
import lombok.Data;

/**
 * @author dax
 * @since 2023/8/4 14:54
 */
@Data
public class TemperatureSetting {
    private TemperatureUnitType unitType;
}
