package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2024/1/24
 */
@ToString
@Getter
public class LinkSubText {
    private final String title;
    private final String url;

    @JsonCreator
    LinkSubText(@JsonProperty("title") String title, @JsonProperty("url") String url) {
        this.title = title;
        this.url = url;
    }
}
