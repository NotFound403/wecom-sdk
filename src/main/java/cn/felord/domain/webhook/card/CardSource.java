package cn.felord.domain.webhook.card;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

/**
 * 卡片来源样式信息
 *
 * @author felord.cn
 * @since 2021/9/3 14:27
 */
@Data
public class CardSource {
    private String iconUrl;
    private String desc;
    private DescColor descColor;

    /**
     * 来源文字颜色
     */
    public enum DescColor {
        /**
         * Grey.
         */
        GREY(0),
        /**
         * Black.
         */
        BLACK(1),
        /**
         * Red.
         */
        RED(2),
        /**
         * Green.
         */
        GREEN(3);

        private final int color;

        DescColor(int color) {
            this.color = color;
        }

        /**
         * Gets color.
         *
         * @return the color
         */
        @JsonValue
        public int getColor() {
            return color;
        }
    }
}
