package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/22 16:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMsgListResponse extends WeComResponse {
    private String nextCursor;
    private Set<GroupMsgDetail> groupMsgList;
}
