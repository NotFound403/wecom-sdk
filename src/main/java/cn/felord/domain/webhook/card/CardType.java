package cn.felord.domain.webhook.card;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 卡片类型.
 */
enum CardType {
    /**
     * Text notice.
     */
    TEXT_NOTICE("text_notice"),
    /**
     * News notice card type.
     */
    NEWS_NOTICE("news_notice");

    private final String type;

    CardType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }
}
