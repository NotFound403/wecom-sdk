package cn.felord.domain.webhook.card;

/**
 * The type Text horizontal content.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:27
 */
public class TextHorizontalContent extends HorizontalContent {
    /**
     * Instantiates a new Text horizontal content.
     *
     * @param keyname the keyname
     */
    public TextHorizontalContent(String keyname) {
        super(HorizontalContentType.TEXT, keyname);
    }

    /**
     * Instantiates a new Text horizontal content.
     *
     * @param keyname the keyname
     * @param value   the value
     */
    public TextHorizontalContent(String keyname, String value) {
        super(HorizontalContentType.TEXT, keyname);
        setValue(value);
    }
}
