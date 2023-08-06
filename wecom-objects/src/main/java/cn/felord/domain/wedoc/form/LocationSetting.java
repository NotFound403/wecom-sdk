package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.DistanceType;
import cn.felord.enumeration.LocationType;
import lombok.Data;

/**
 * @author dax
 * @since 2023/8/4 14:05
 */
@Data
public class LocationSetting {
    private LocationType locationType;
    private DistanceType distanceType;
}
