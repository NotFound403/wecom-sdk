package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/22 16:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMsgListResponse extends CursorWeComResponse {
    private List<GroupMsgDetail> groupMsgList;
}
