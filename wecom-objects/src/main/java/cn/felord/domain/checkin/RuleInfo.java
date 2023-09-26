package cn.felord.domain.checkin;

import lombok.Data;

import java.util.List;

@Data
public class RuleInfo {
    /**
     * 所属规则的id
     */
    private Integer groupid;
    /**
     * 打卡规则名
     */
    private String groupname;
    /**
     * 当日所属班次id，仅按班次上下班才有值，显示在打卡日报-班次列
     */
    private Integer scheduleid;
    /**
     * 当日所属班次名称，仅按班次上下班才有值，显示在打卡日报-班次列
     */
    private String schedulename;
    /**
     * 当日打卡时间，仅固定上下班规则有值，显示在打卡日报-班次列
     */
    private List<CheckinDayTime> checkintime;
}