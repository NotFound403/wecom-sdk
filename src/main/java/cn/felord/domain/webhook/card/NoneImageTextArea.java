package cn.felord.domain.webhook.card;

/**
 * @author felord.cn
 * @since 2021/9/3 15:06
 */
public class NoneImageTextArea extends ImageTextArea {
    public NoneImageTextArea(String imageUrl) {
        super(ClickEventType.NONE, imageUrl);
    }
}
