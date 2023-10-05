package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfMsgOrigin;
import cn.felord.enumeration.KfMsgType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * The type Merged kf message.
 *
 * @author dax
 * @since 2023 /10/5
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class MergedKfMessage extends KfMessage {
    private final MergedMsg mergedMsg;

    /**
     * Instantiates a new Merged kf message.
     *
     * @param msgid          the msgid
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param sendTime       the send time
     * @param origin         the origin
     * @param servicerUserid the servicer userid
     * @param mergedMsg      the merged msg
     */
    @JsonCreator
    public MergedKfMessage(@JsonProperty("msgid") String msgid,
                           @JsonProperty("open_kfid") String openKfid,
                           @JsonProperty("external_userid") String externalUserid,
                           @JsonProperty("send_time") Instant sendTime,
                           @JsonProperty("origin") KfMsgOrigin origin,
                           @JsonProperty("servicer_userid") String servicerUserid,
                           @JsonProperty("merged_msg") MergedMsg mergedMsg) {
        super(KfMsgType.MERGED_MSG, msgid, openKfid, externalUserid, sendTime, origin, servicerUserid);
        this.mergedMsg = mergedMsg;
    }
}
