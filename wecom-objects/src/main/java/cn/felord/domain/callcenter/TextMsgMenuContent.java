package cn.felord.domain.callcenter;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 文本菜单
 *
 * @author dax
 * @since 2023 /9/15
 */
@ToString
@Getter
public class TextMsgMenuContent extends MsgMenuContent {
    private final MenuText text;

    /**
     * Instantiates a new Text msg menu content.
     *
     * @param text the text
     */
    @JsonCreator
    TextMsgMenuContent(@JsonProperty("text") MenuText text) {
        super(MsgMenuContentType.TEXT);
        this.text = text;
    }

    /**
     * Instantiates a new Text msg menu content.
     *
     * @param content the content
     */
    public TextMsgMenuContent(String content) {
        this(new MenuText(content));
    }

    /**
     * Instantiates a new Text msg menu content.
     *
     * @param content   the content
     * @param noNewline the no newline
     */
    public TextMsgMenuContent(String content, BoolEnum noNewline) {
        this(new MenuText(content, noNewline));
    }
}
