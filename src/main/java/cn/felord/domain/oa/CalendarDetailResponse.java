package cn.felord.domain.oa;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/22 11:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CalendarDetailResponse extends WeComResponse {
    private List<CalendarDetail> calendarList;
}
