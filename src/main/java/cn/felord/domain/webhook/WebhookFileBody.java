package cn.felord.domain.webhook;

import cn.felord.enumeration.MsgType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WebhookFileBody extends WebhookBody {
    private WebhookFile file;

    public WebhookFileBody() {
        setMsgtype(MsgType.FILE);
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookFile {
        private String mediaId;
    }

}
