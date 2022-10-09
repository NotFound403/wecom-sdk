package cn.felord.domain.webhook;

import cn.felord.enumeration.HookMsgType;
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
public class WebhookImageBody extends WebhookBody {
    private WebhookImage image;

    public WebhookImageBody() {
        super(HookMsgType.IMAGE);
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
