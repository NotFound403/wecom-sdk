package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfMsgOrigin;
import cn.felord.enumeration.KfMsgType;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/12/8 17:50
 */
@Data
public class KfMsg {
    private String msgid;
    private String openKfid;
    private String externalUserid;
    private Instant sendTime;
    private KfMsgOrigin origin;
    private String servicerUserid;
    private KfMsgType msgType;
}
