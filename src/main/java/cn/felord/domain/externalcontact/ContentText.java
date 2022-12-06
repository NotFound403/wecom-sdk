package cn.felord.domain.externalcontact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:11
 */
@Getter
public class ContentText {
    private final String content;

    @JsonCreator
    public ContentText(@JsonProperty("content") String content) {
        this.content = content;
    }
}
