package cn.felord.domain.externalcontact;

import cn.felord.enumeration.GroupMsgSendResultStatus;
import lombok.Data;

import java.time.Instant;

/**
 * @author xiafang
 * @since 2022/9/22 17:29
 */
@Data
public class GroupMsgSendResult {
    private String externalUserid;
    private String chatId;
    private String userid;
    private GroupMsgSendResultStatus status;
    private Instant sendTime;
}
