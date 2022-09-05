package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.Setter;

/**
 * 左图又文样式
 */
@Getter
@Setter
public abstract class ImageTextArea {
    private final ClickEventType type;
    private String title;
    private String desc;
    private final String imageUrl;

    protected ImageTextArea(ClickEventType type, String imageUrl) {
        this.type = type;
        this.imageUrl = imageUrl;
    }
}
