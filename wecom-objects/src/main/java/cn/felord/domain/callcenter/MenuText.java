package cn.felord.domain.callcenter;

import cn.felord.enumeration.BoolEnum;
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
public class MenuText {
    private final String content;
    private final BoolEnum noNewline;

    /**
     * Instantiates a new Menu text.
     *
     * @param content   the content
     * @param noNewline the no newline
     */
    @JsonCreator
    public MenuText(@JsonProperty("content") String content, @JsonProperty("no_newline") BoolEnum noNewline) {
        this.content = content;
        this.noNewline = noNewline;
    }

    /**
     * Instantiates a new Menu text.
     *
     * @param content the content
     */
    public MenuText(String content) {
        this(content, BoolEnum.FALSE);
    }
}
