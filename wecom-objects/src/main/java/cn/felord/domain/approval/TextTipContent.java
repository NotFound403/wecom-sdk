package cn.felord.domain.approval;

import cn.felord.domain.common.PlainText;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Text tip content.
 *
 * @author dax
 * @since 2024/1/24
 */
@ToString
@Getter
public class TextTipContent {
    private final PlainText plainText;

    /**
     * Instantiates a new Text tip content.
     *
     * @param plainText the plain text
     */
    @JsonCreator
    TextTipContent(@JsonProperty("plain_text") PlainText plainText) {
        this.plainText = plainText;
    }

    TextTipContent(String content) {
        this.plainText = new PlainText(content);
    }
}
