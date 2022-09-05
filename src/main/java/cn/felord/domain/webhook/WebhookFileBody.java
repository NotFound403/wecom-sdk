package cn.felord.domain.webhook;

import cn.felord.enumeration.MsgType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class WebhookFileBody extends WebhookBody {
    private WebhookFile file;

    public WebhookFileBody() {
        super(MsgType.FILE);
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookFile {
        private String mediaId;
    }

}
