package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
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
public class ServicerRecallMsgKfEvent extends KfEvent {

    private final String recallMsgid;
    private final String servicerUserid;

    @JsonCreator
    public ServicerRecallMsgKfEvent(@JsonProperty("open_kfid") String openKfid,
                                    @JsonProperty("external_userid") String externalUserid,
                                    @JsonProperty("recall_msgid") String recallMsgid,
                                    @JsonProperty("servicer_userid") String servicerUserid) {
        super(KfEventType.SERVICER_RECALL_MSG, openKfid, externalUserid);
        this.recallMsgid = recallMsgid;
        this.servicerUserid = servicerUserid;
    }
}
