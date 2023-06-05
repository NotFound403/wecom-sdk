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
 * The type Text kf message.
 *
 * @author dax
 * @since 2023 /6/3
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class TextKfMessage extends KfMessage {
    private final KfText text;

    /**
     * Instantiates a new Text kf message.
     *
     * @param msgid          the msgid
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param sendTime       the send time
     * @param origin         the origin
     * @param servicerUserid the servicer userid
     * @param text           the text
     */
    @JsonCreator
    public TextKfMessage(@JsonProperty("msgid") String msgid,
                         @JsonProperty("open_kfid") String openKfid,
                         @JsonProperty("external_userid") String externalUserid,
                         @JsonProperty("send_time") Instant sendTime,
                         @JsonProperty("origin") KfMsgOrigin origin,
                         @JsonProperty("servicer_userid") String servicerUserid,
                         @JsonProperty("text") KfText text) {
        super(KfMsgType.TEXT, msgid, openKfid, externalUserid, sendTime, origin, servicerUserid);
        this.text = text;
    }
}
