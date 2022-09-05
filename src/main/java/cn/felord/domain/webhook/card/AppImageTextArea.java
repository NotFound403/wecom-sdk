package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:08
 */
@Getter
public class AppImageTextArea extends ImageTextArea{
    private final String appid;
    private final String pagepath;
    public AppImageTextArea(String imageUrl, String appid, String pagepath) {
        super(ClickEventType.APP, imageUrl);
        this.appid = appid;
        this.pagepath = pagepath;
    }
}
