package cn.felord.domain.callcenter.knowledge;

import lombok.Data;

@Data
public class GroupsRequest {
    private String cursor;
    private String groupId;
    private Integer limit;
}