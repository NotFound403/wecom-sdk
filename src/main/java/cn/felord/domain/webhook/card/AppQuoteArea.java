package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 14:56
 */
@Getter
public class AppQuoteArea extends QuoteArea {
    private final String appid;
    private final String pagepath;

    public AppQuoteArea(String appid, String pagepath) {
        super(ClickEventType.APP);
        this.appid = appid;
        this.pagepath = pagepath;
    }
}
