package cn.felord.domain.webhook;

import cn.felord.enumeration.HookMsgType;
import lombok.Getter;


/**
 * @author n1
 * @since 2021/6/16 14:57
 */
@Getter
public abstract class WebhookBody {
    private final String msgtype;

    protected WebhookBody(HookMsgType msgtype) {
        this.msgtype = msgtype.name().toLowerCase();
    }
}
