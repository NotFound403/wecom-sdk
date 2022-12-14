package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/15 19:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupChatListResponse extends CursorWeComResponse {
    private List<ChatListItem> groupChatList;
}
