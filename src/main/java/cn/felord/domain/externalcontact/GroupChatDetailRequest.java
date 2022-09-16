package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/15 17:46
 */
@Data
public abstract class GroupChatDetailRequest {
   private final String chatId;
   private final Integer needName;
}
