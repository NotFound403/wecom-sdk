package cn.felord.domain.webhook;

import cn.felord.domain.externalcontact.MediaId;
import cn.felord.enumeration.HookMsgType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class WebhookFileBody extends WebhookBody {
    private final MediaId file;

    public WebhookFileBody(MediaId file) {
        super(HookMsgType.FILE);
        this.file = file;
    }

}
