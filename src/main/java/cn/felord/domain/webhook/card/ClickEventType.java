package cn.felord.domain.webhook.card;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 点击事件
 *
 * @author felord.cn
 * @since 2021/9/3 14:37
 */
enum ClickEventType {
    /**
     * None.
     */
    NONE(0),
    /**
     * Url.
     */
    URL(1),
    /**
     * App.
     */
    APP(2);

    private final int type;

    ClickEventType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }
}
