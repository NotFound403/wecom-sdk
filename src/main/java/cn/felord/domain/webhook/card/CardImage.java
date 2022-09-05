package cn.felord.domain.webhook.card;

import lombok.Data;

/**
 * 图片样式
 *
 * @author felord.cn
 * @since 2021/9/3 14:30
 */
@Data
public class CardImage {
    private final String url;
    private Double aspectRatio;
}
