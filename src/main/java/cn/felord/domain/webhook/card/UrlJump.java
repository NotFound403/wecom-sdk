package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:38
 */
@Getter
public class UrlJump extends Jump {
    private final String url;
    public UrlJump(String title, String url) {
        super(ClickEventType.URL, title);
        this.url = url;
    }
}
