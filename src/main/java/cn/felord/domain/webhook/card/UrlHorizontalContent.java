package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * @author felord.cn
 * @since 2021/9/3 15:28
 */
@Getter
public class UrlHorizontalContent extends HorizontalContent {
    private final String url;
    public UrlHorizontalContent(String keyname, String url) {
        super(HorizontalContentType.URL, keyname);
        this.url = url;
    }
}
