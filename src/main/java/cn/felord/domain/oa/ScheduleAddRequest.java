package cn.felord.domain.oa;

import lombok.Data;

@Data
public class ScheduleAddRequest {
    private final Schedule schedule;
    private Integer agentid;
}