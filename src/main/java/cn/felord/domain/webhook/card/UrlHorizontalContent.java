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
        super(HorizontalContentType.URL, keyname);
        this.url = url;
    }

    /**
     * Instantiates a new Url horizontal content.
     *
     * @param keyname the keyname
     * @param url     the url
     * @param value   the value
     */
    public UrlHorizontalContent(String keyname, String url, String value) {
        super(HorizontalContentType.URL, keyname);
        this.url = url;
        setValue(value);
    }
}
