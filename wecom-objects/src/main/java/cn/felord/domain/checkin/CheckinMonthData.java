package cn.felord.domain.checkin;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Checkin month data.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CheckinMonthData extends AbstractCheckinData {

    /**
     * 加班情况
     */
    private OverworkInfo overworkInfo;
}