package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Plain text.
 *
 * @author dax
 * @since 2024/1/24
 */
@ToString
@Getter
public class PlainText {
    private final String content;

    /**
     * Instantiates a new Plain text.
     *
     * @param content the content
     */
    @JsonCreator
    public PlainText(@JsonProperty("content") String content) {
        this.content = content;
    }
}
