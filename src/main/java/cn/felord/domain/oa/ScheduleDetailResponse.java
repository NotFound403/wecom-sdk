package cn.felord.domain.oa;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author felord
 * @since 2021/11/22 9:26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ScheduleDetailResponse extends WeComResponse {
    private List<ScheduleDetail> scheduleList;
}
