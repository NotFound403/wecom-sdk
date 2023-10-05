package cn.felord.domain.callcenter.knowledge;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GroupsResponse extends WeComResponse {
    private String nextCursor;
    private List<KnowledgeGroupDetail> groupList;
    private Integer hasMore;
}