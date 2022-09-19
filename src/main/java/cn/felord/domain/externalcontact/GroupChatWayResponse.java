package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ContactScene;
import cn.felord.enumeration.CreateRoomMode;
import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/9/19 13:51
 */
@Data
public class GroupChatWayResponse {
    private String configId;
    private ContactScene scene;
    private String remark;
    private CreateRoomMode autoCreateRoom;
    private String roomBaseName;
    private String qrCode;
    private Integer roomBaseId;
    private Set<String> chatIdList;
    private String state;
}
