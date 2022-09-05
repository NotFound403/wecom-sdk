package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:43
 */
@Getter
public class UrlCardAction extends CardAction {
    private final String url;
    public UrlCardAction(String url) {
        super(ClickEventType.URL);
        this.url = url;
    }
}
