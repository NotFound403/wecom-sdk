package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 14:56
 */
@Getter
public class UrlQuoteArea extends QuoteArea{
    private final String url;
    public UrlQuoteArea(String url) {
        super(ClickEventType.URL);
        this.url = url;
    }
}
