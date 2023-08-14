package cn.felord.domain.approval;

import lombok.Data;

import java.time.Duration;

/**
 * @author dax
 * @since 2023/8/14
 */
@Data
public class VacationQuota {
    private Long id;
    private Duration assignduration;
    private Duration usedduration;
    private Duration leftduration;
    private Duration realAssignduration;
    private String vacationname;
}
