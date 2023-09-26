package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Duration;

@Data
public class SummaryInfo {
    /**
     * 当日打卡次数
     */
    private Integer checkinCount;
    /**
     * 当日实际工作时长，单位：秒
     */
    private Duration regularWorkSec;
    /**
     * 当日标准工作时长，单位：秒
     */
    private Duration standardWorkSec;
    /**
     * 当日最早打卡时间，距离0点
     */
    private Duration earliestTime;
    /**
     * 当日最晚打卡时间，距离0点
     */
    private Duration lastestTime;
}