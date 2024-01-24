package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Sub texts.
 *
 * @author dax
 * @since 2024/1/24
 */
@ToString
@Getter
public class SubTexts {
    private final List<TipSubText<?>> subText;

    /**
     * Instantiates a new Sub texts.
     *
     * @param subText the sub text
     */
    @JsonCreator
    SubTexts(@JsonProperty("sub_text") List<TipSubText<?>> subText) {
        this.subText = subText;
    }
}
