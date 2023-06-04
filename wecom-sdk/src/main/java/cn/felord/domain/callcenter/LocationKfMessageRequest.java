package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class LocationKfMessageRequest extends KfMessageRequest {
    private final KfLocation location;


    public LocationKfMessageRequest(String touser, String openKfid, KfLocation location) {
        this(touser, openKfid, null, location);
    }

    public LocationKfMessageRequest(String touser, String openKfid, String msgid, KfLocation location) {
        super(touser, openKfid, msgid, KfMsgType.IMAGE);
        this.location = location;
    }
}
