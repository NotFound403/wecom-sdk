package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Link tip content.
 *
 * @author dax
 * @since 2024/1/24
 */
@ToString
@Getter
public class LinkTipContent {
    private final LinkSubText link;

    /**
     * Instantiates a new Link tip content.
     *
     * @param link the link
     */
    @JsonCreator
    LinkTipContent(@JsonProperty("link") LinkSubText link) {
        this.link = link;
    }
}
