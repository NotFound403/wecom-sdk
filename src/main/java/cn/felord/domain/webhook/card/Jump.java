package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * 引用文献样式，建议不与关键数据共用
 *
 * @author felord.cn
 * @since 2021/9/3 14:36
 */
@Getter
public abstract class Jump {
    private final ClickEventType type;

    private final String title;

    protected Jump(ClickEventType type, String title) {
        this.type = type;
        this.title = title;
    }

}
