package cn.felord.domain.checkin;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeviceCheckinDataResponse extends WeComResponse {
    private List<DeviceCheckinData> checkindata;
}
