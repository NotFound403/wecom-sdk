package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Duration;

/**
 * 加班情况
 *
 * @author dax
 * @since 2023 /9/26
 */
@Data
public class OverworkInfo {
    /**
     * 工作日加班时长
     */
    private Duration workdayOverSec;
    /**
     * 节假日加班时长
     */
    private Duration holidaysOverSec;
    /**
     * 休息日加班时长
     */
    private Duration restdaysOverSec;
}
