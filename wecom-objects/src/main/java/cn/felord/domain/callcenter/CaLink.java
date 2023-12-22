package cn.felord.domain.callcenter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Ca link.
 *
 * @author dax
 * @since 2023 /12/22
 */
@ToString
@Getter
public class CaLink {
    private final String linkUrl;

    /**
     * Instantiates a new Ca link.
     *
     * @param linkUrl the link url
     */
    @JsonCreator
    public CaLink(@JsonProperty("link_url") String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
