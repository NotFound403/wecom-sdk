package cn.felord.domain.oa;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;

/**
 * The type Schedule detail request.
 *
 * @author dax
 * @since 2023 /10/5
 */
@ToString
@Getter
public class ScheduleDetailRequest {
    private final Set<String> scheduleIdList;

    /**
     * Instantiates a new Schedule detail request.
     *
     * @param scheduleIdList the schedule id list
     */
    ScheduleDetailRequest(Set<String> scheduleIdList) {
        this.scheduleIdList = scheduleIdList;
    }

    /**
     * From schedule detail request.
     *
     * @param scheduleId the schedule id
     * @return the schedule detail request
     */
    public static ScheduleDetailRequest from(String scheduleId) {
        return from(Collections.singleton(scheduleId));
    }

    /**
     * From schedule detail request.
     *
     * @param scheduleIdList the schedule id list
     * @return the schedule detail request
     */
    public static ScheduleDetailRequest from(Set<String> scheduleIdList) {
        return new ScheduleDetailRequest(scheduleIdList);
    }

}
