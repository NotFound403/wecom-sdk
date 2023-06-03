package cn.felord.domain.callcenter;

import cn.felord.enumeration.FailKfEventType;
import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Msg send fail kf event.
 *
 * @author dax
 * @since 2023 /6/4
 */
@ToString
@Getter
public class MsgSendFailKfEvent extends KfEvent {

    private final String failMsgid;
    private final FailKfEventType failType;

    /**
     * Instantiates a new Msg send fail kf event.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param failMsgid      the fail msgid
     * @param failType       the fail type
     */
    @JsonCreator
    public MsgSendFailKfEvent(@JsonProperty("open_kfid") String openKfid,
                              @JsonProperty("external_userid") String externalUserid,
                              @JsonProperty("fail_msgid") String failMsgid,
                              @JsonProperty("fail_type") FailKfEventType failType) {
        super(KfEventType.MSG_SEND_FAIL, openKfid, externalUserid);
        this.failMsgid = failMsgid;
        this.failType = failType;
    }
}
