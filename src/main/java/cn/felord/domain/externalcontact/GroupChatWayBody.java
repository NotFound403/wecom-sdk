package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ContactScene;
import cn.felord.enumeration.CreateRoomMode;
import lombok.Data;

import java.util.Set;

/**
 * @author felord.cn
 * @since 2021/9/19 10:57
 */
@Data
public class GroupChatWayBody {
   private final ContactScene scene;
   private String remark;
   private CreateRoomMode autoCreateRoom = CreateRoomMode.NEW;
   private String roomBaseName;
   private Integer roomBaseId;
   private Set<String> chatIdList;
   private String state;
}
