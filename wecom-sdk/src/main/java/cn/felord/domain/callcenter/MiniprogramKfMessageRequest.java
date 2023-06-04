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
public class MiniprogramKfMessageRequest extends KfMessageRequest {
    private final KfMiniprogram miniprogram;


    public MiniprogramKfMessageRequest(String touser, String openKfid, KfMiniprogram miniprogram) {
        this(touser, openKfid, null, miniprogram);
    }

    public MiniprogramKfMessageRequest(String touser, String openKfid, String msgid, KfMiniprogram miniprogram) {
        super(touser, openKfid, msgid, KfMsgType.MINIPROGRAM);
        this.miniprogram = miniprogram;
    }

}
