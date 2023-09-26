package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Duration;

/**
 * The type Checkin day time.
 */
@Data
public class CheckinDayTime {
    /**
     * 上班时间，为距离0点的时间差
     */
    private Duration workSec;
    /**
     * 下班时间，为距离0点的时间差
     */
    private Duration offWorkSec;
}