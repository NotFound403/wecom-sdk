package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/5/26
 */
@ToString
@Getter
public class TextValue implements ContentDataValue {
    private final String text;

    @JsonCreator
    public TextValue(@JsonProperty("text") String text) {
        this.text = text;
    }
}
