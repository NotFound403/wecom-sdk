package cn.felord.domain.webhook;

import cn.felord.enumeration.HookMsgType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type Webhook text body.
 *
 * @author n1
 * @since 2021 /6/16 15:02
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class WebhookTextBody extends WebhookBody {
    private WebhookText text;

    public WebhookTextBody() {
        super(HookMsgType.TEXT);
    }

    /**
     * The type Text.
     */
    @Data
    public static class WebhookText {
        private String content;
        private List<String> mentionedList;
        private List<String> mentionedMobileList;
    }

}
