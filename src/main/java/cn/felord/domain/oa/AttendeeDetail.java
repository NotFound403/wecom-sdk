package cn.felord.domain.oa;

import cn.felord.enumeration.ScheduleAttendeeResponseStatus;
import lombok.Data;

/**
 * @author xiafang
 * @since 2022/11/21 17:18
 */
@Data
public class AttendeeDetail {
    private String userid;
    private ScheduleAttendeeResponseStatus responseStatus;
}
