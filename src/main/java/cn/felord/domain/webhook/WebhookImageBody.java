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
public class WebhookImageBody extends WebhookBody {
    private WebhookImage image;

    public WebhookImageBody() {
        setMsgtype(MsgType.IMAGE);
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookImage {
        private String base64;
        private String md5;
    }

}
