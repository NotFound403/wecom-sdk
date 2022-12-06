package cn.felord.domain.webhook;

import cn.felord.enumeration.HookMsgType;
import lombok.Data;
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
public class WebhookImageBody extends WebhookBody {
    private final WebhookImage image;

    public WebhookImageBody(WebhookImage image) {
        super(HookMsgType.IMAGE);
        this.image = image;
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
