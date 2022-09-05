package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:44
 */
@Getter
public class AppCardAction extends CardAction {
    private final String appid;
    private final String pagepath;
    public AppCardAction(ClickEventType type, String appid, String pagepath) {
        super(type);
        this.appid = appid;
        this.pagepath = pagepath;
    }
}
