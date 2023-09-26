package cn.felord.domain.checkin;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/9/26
 */
@Data
public abstract class AbstractCheckinData {
    /**
     * 基础信息
     */
    private BaseInfo baseInfo;
    /**
     * 校准状态信息
     */
    private List<ExceptionInfo> exceptionInfos;
    /**
     * 假勤统计信息
     */
    private List<SpItem> spItems;
    /**
     * 加班信息
     */
    private SpOtInfo otInfo;
    /**
     * 汇总信息
     */
    private SummaryInfo summaryInfo;
}
