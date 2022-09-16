package cn.felord.domain.externalcontact;

import cn.felord.enumeration.GroupChatStatus;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/15 17:32
 */
@Data
public class ChatListItem {
    private String chatId;
    private GroupChatStatus status;
}
