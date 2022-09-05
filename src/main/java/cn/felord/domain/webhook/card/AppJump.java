package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 14:56
 */
@Getter
public class AppJump extends Jump {
    private final String appid;
    private final String pagepath;

    public AppJump(String title, String appid, String pagepath) {
        super(ClickEventType.APP,title);
        this.appid = appid;
        this.pagepath = pagepath;
    }
}
