package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MsgSendOptStatus;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/7/22 19:08
 */
@Data
public class GroupMsgTaskDetail {
    private String userid;
    private MsgSendOptStatus status;
    private Instant sendTime;

}
