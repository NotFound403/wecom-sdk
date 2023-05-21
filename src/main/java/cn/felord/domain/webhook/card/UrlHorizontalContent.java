package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * The type Url horizontal content.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:28
 */
@Getter
public class UrlHorizontalContent extends HorizontalContent {
    private final String url;

    /**
     * Instantiates a new Url horizontal content.
     *
     * @param keyname the keyname
     * @param url     the url
     */
    public UrlHorizontalContent(String keyname, String url) {
        this(keyname, url, null);
    }

    /**
     * Instantiates a new Url horizontal content.
     *
     * @param keyname the keyname
     * @param url     the url
     * @param value   the value
     */
    public UrlHorizontalContent(String keyname, String url, String value) {
        super(HorizontalContentType.URL, keyname, value);
        this.url = url;
    }
}
