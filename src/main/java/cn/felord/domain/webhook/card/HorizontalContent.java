package cn.felord.domain.webhook.card;

import lombok.Getter;
import lombok.Setter;

/**
 * 二级标题 文本列表
 *
 * @author felord.cn
 * @since 2021/9/3 15:22
 */
@Setter
@Getter
public abstract class HorizontalContent {
    private final HorizontalContentType type;
    private final String keyname;
    private String value;

    protected HorizontalContent(HorizontalContentType type, String keyname) {
        this.type = type;
        this.keyname = keyname;
    }
}
