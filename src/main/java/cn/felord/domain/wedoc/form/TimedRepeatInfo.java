package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormForkFinishType;
import cn.felord.enumeration.FormRepeatType;
import cn.felord.enumeration.FormWeekFlag;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/3/13 17:17
 */
@Data
public class TimedRepeatInfo {
    private Boolean enable;
    private Instant remindTime;
    private FormRepeatType repeatType;
    private FormWeekFlag weekFlag;
    private Boolean skipHoliday;
    private Integer dayOfMonth;
    private FormForkFinishType formForkFinishType;
}
