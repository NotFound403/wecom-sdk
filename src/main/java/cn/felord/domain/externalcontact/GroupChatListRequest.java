package cn.felord.domain.externalcontact;

import cn.felord.enumeration.GroupChatStatus;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/15 11:37
 */
@Data
public class GroupChatListRequest {
    private GroupChatStatus statusFilter;
    private OwnerFilter ownerFilter;
    private String cursor;
    private final Integer limit;
}
