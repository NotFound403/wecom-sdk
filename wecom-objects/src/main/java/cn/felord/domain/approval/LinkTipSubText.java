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
public class LinkTipSubText extends TipSubText<LinkTipContent> {


    /**
     * Instantiates a new Tip sub text.
     *
     * @param type    the type
     * @param content the content
     */
    @JsonCreator
    LinkTipSubText(@JsonProperty("type") TipsCtrlType type, @JsonProperty("content") LinkTipContent content) {
        super(type, content);
    }

}
