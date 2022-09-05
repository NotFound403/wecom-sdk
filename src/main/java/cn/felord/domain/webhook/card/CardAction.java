package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:42
 */
@Getter
public abstract class CardAction {
 private final ClickEventType type;

    protected CardAction(ClickEventType type) {
        this.type = type;
    }
}
