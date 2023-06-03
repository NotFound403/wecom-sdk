package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Servicer status change kf event.
 *
 * @author dax
 * @since 2023 /6/4
 */
@ToString
@Getter
public class ServicerStatusChangeKfEvent extends KfEvent {

    private final String recallMsgid;

    /**
     * Instantiates a new Servicer status change kf event.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param recallMsgid    the recall msgid
     */
    @JsonCreator
    public ServicerStatusChangeKfEvent(@JsonProperty("open_kfid") String openKfid,
                                       @JsonProperty("external_userid") String externalUserid,
                                       @JsonProperty("recall_msgid") String recallMsgid) {
        super(KfEventType.SERVICER_STATUS_CHANGE, openKfid, externalUserid);
        this.recallMsgid = recallMsgid;
    }
}
