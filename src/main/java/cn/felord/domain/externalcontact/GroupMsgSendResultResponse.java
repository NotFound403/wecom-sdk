package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/22 16:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMsgSendResultResponse extends CursorWeComResponse {
    private List<GroupMsgSendResult> sendList;
}
