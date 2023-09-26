package cn.felord.domain.checkin;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CheckinDayData extends AbstractCheckinData {

    /**
     * 假勤相关信息
     */
    private List<HolidayInfo> holidayInfos;
}