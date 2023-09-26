package cn.felord.domain.checkin;

import cn.felord.enumeration.CheckinExceptionType;
import lombok.Data;

@Data
public class ExceptionInfo {
    /**
     * 当日此异常的时长（迟到/早退/旷工才有值）
     */
    private Integer duration;
    /**
     * 校准状态类型：1-迟到；2-早退；3-缺卡；4-旷工；5-地点异常；6-设备异常
     */
    private CheckinExceptionType exception;
    /**
     * 当日此异常的次数
     */
    private Integer count;
}