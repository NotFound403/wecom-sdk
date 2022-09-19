package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ContactScene;
import cn.felord.enumeration.CreateRoomMode;
import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/9/19 14:01
 */
@Data
public class MutableGroupChatWayBody {

    private final String configId;
    private final ContactScene scene;
    private String remark;
    private CreateRoomMode autoCreateRoom = CreateRoomMode.NEW;
    private String roomBaseName;
    private Integer roomBaseId;
    private final Set<String> chatIdList;
    private String state;
}
