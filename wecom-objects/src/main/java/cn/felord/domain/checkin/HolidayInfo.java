package cn.felord.domain.checkin;

import lombok.Data;

/**
 * The type Holiday info.
 */
@Data
public class HolidayInfo {
    /**
     * 假勤申请id，即当日关联的假勤审批单id
     */
    private String spNumber;
    /**
     * 假勤信息摘要-标题信息，目前只有中文一种
     */
    private SpTitle spTitle;
    /**
     * 假勤信息摘要-描述信息，目前只有中文一种
     */
    private SpDescription spDescription;
}