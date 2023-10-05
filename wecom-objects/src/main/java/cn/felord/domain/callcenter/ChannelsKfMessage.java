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
 * The type Channels kf message.
 *
 * @author dax
 * @since 2023 /10/5
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class ChannelsKfMessage extends KfMessage {
    private final ChannelsMsg channels;

    /**
     * Instantiates a new Channels kf message.
     *
     * @param msgid          the msgid
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param sendTime       the send time
     * @param origin         the origin
     * @param servicerUserid the servicer userid
     * @param channels       the channels
     */
    @JsonCreator
    public ChannelsKfMessage(@JsonProperty("msgid") String msgid,
                             @JsonProperty("open_kfid") String openKfid,
                             @JsonProperty("external_userid") String externalUserid,
                             @JsonProperty("send_time") Instant sendTime,
                             @JsonProperty("origin") KfMsgOrigin origin,
                             @JsonProperty("servicer_userid") String servicerUserid,
                             @JsonProperty("channels") ChannelsMsg channels) {
        super(KfMsgType.CHANNELS, msgid, openKfid, externalUserid, sendTime, origin, servicerUserid);
        this.channels = channels;
    }
}
