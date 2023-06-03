package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import cn.felord.enumeration.SessionStatusChangeType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class SessionStatusChangeKfEvent extends KfEvent {

    private final SessionStatusChangeType changeType;
    private final String oldServicerUserid;
    private final String newServicerUserid;
    private final String msgCode;

    @JsonCreator
    public SessionStatusChangeKfEvent(@JsonProperty("open_kfid")String openKfid,
                                      @JsonProperty("external_userid") String externalUserid,
                                      @JsonProperty("change_type") SessionStatusChangeType changeType,
                                      @JsonProperty("old_servicer_userid") String oldServicerUserid,
                                      @JsonProperty("new_servicer_userid") String newServicerUserid,
                                      @JsonProperty("msg_code") String msgCode) {
        super(KfEventType.SESSION_STATUS_CHANGE, openKfid, externalUserid);
        this.changeType = changeType;
        this.oldServicerUserid = oldServicerUserid;
        this.newServicerUserid = newServicerUserid;
        this.msgCode = msgCode;
    }
}
