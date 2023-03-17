package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormRepeatType;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/3/13 17:17
 */
@Data
public class TimedRepeatInfoDetail {
    private Boolean enable;
    private Instant remindTime;
    private Instant ruleCtime;
    private Instant ruleMtime;
    private FormRepeatType repeatType;
    private Boolean skipHoliday;

}
