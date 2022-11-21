package cn.felord.domain.oa;

import lombok.Data;

@Data
public class ScheduleAddRequest {
    private final ScheduleRequestBody schedule;
    private Integer agentid;
}