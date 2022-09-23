package cn.felord.domain.externalcontact;

import cn.felord.enumeration.MsgAttachType;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class MiniprogramMsgAttachment extends MsgAttachment {
    private final Miniprogram miniprogram;

    public MiniprogramMsgAttachment(Miniprogram miniprogram) {
        super(MsgAttachType.MINIPROGRAM);
        this.miniprogram = miniprogram;
    }
}
