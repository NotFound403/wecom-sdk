package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/15 17:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupChatListResponse extends WeComResponse {
    private Set<ChatListItem> groupChatList;
    private String nextCursor;
}
