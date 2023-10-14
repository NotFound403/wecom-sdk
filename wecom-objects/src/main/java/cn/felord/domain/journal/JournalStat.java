package cn.felord.domain.journal;

import cn.felord.enumeration.JournalReportType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
@Data
public class JournalStat {
    /**
     * 汇报表单id
     */
    private String templateId;
    /**
     * 汇报表单名称
     */
    private String templateName;
    /**
     * 汇报人员范围
     */
    private ReportUserRange reportRange;
    /**
     * 白名单集合
     */
    private ReportUserRange whiteRange;
    /**
     * 固定汇报对象
     */
    private Receivers receivers;
    /**
     * 周期开始时间
     */
    private Instant cycleBeginTime;
    /**
     * 周期结束时间
     */
    private Instant cycleEndTime;
    /**
     * 统计开始时间
     */
    private Instant statBeginTime;
    /**
     * 统计结束时间
     */
    private Instant statEndTime;
    /**
     * 已汇报用户列表
     */
    private List<ReportItem> reportList;
    /**
     * 未汇报用户列表
     */
    private List<ReportItem> unreportList;
    /**
     * 汇报方式
     */
    private JournalReportType reportType;
}