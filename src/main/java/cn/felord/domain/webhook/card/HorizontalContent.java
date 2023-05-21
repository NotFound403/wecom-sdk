package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * 二级标题 文本列表
 *
 * @author felord.cn
 * @since 2021/9/3 15:22
 */

@Getter
public abstract class HorizontalContent {
    private final HorizontalContentType type;
    private final String keyname;
    private final String value;

    public HorizontalContent(HorizontalContentType type, String keyname, String value) {
        this.type = type;
        this.keyname = keyname;
        this.value = value;
    }
}
