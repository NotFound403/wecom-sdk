package cn.felord.domain.webhook;

import cn.felord.enumeration.HookMsgType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class WebhookTextBody extends WebhookBody {
    private final WebhookText text;

    public WebhookTextBody(WebhookText text) {
        super(HookMsgType.TEXT);
        this.text = text;
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookText {
        private final String content;
        private List<String> mentionedList;
        private List<String> mentionedMobileList;
    }

}
