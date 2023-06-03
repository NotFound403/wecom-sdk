package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type User recall msg kf event.
 *
 * @author dax
 * @since 2023 /6/4
 */
@ToString
@Getter
public class UserRecallMsgKfEvent extends KfEvent {
    private final String recallMsgid;

    /**
     * Instantiates a new User recall msg kf event.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param recallMsgid    the recall msgid
     */
    @JsonCreator
    public UserRecallMsgKfEvent(@JsonProperty("open_kfid") String openKfid,
                                @JsonProperty("external_userid") String externalUserid,
                                @JsonProperty("recall_msgid") String recallMsgid) {
        super(KfEventType.USER_RECALL_MSG, openKfid, externalUserid);
        this.recallMsgid = recallMsgid;
    }
}
