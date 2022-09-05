package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:09
 */
@Getter
public class UrlImageTextArea extends ImageTextArea {
    private final String url;

    public UrlImageTextArea(String imageUrl, String url) {
        super(ClickEventType.URL, imageUrl);
        this.url = url;
    }
}
