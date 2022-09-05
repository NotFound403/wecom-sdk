package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.Setter;

/**
 * 引用文献样式，建议不与关键数据共用
 *
 * @author felord.cn
 * @since 2021/9/3 14:36
 */
@Getter
@Setter
public abstract class QuoteArea {
    private final ClickEventType type;

    protected QuoteArea(ClickEventType type) {
        this.type = type;
    }

    private String title;
    private String quoteText;
}
