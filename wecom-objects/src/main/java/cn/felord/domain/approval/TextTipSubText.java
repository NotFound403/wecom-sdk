package cn.felord.domain.approval;

import cn.felord.enumeration.TipsCtrlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2024/1/24
 */
@ToString(callSuper = true)
@Getter
public class TextTipSubText extends TipSubText<TextTipContent> {
    /**
     * Instantiates a new Tip sub text.
     *
     * @param type    the type
     * @param content the content
     */
    @JsonCreator
    TextTipSubText(@JsonProperty("type") TipsCtrlType type, @JsonProperty("content") TextTipContent content) {
        super(type, content);
    }

}
