package cn.felord.domain.externalcontact;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2021/9/23 14:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupChatDataByOwner extends GroupChatData {
    private String owner;
}
