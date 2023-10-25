package cn.felord.domain.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Item.
 *
 * @author dax
 * @since 2023 /10/25
 */
@Data
public class Item {
    private final String title;
    private String pagepath;
    private String jumpUrl;

    /**
     * Instantiates a new Image.
     *
     * @param title    the title
     * @param pagepath the pagepath
     * @param jumpUrl  the jump url
     */
    @JsonCreator
    public Item(@JsonProperty("title") String title,
                @JsonProperty("pagepath") String pagepath,
                @JsonProperty("jump_url") String jumpUrl) {
        this.title = title;
        this.pagepath = pagepath;
        this.jumpUrl = jumpUrl;
    }

    /**
     * Instantiates a new Image.
     *
     * @param title the title
     */
    public Item(String title) {
        this.title = title;
    }

    /**
     * Pagepath item.
     *
     * @param pagepath the pagepath
     * @return the item
     */
    public Item pagepath(String pagepath) {
        this.pagepath = pagepath;
        return this;
    }

    /**
     * Jump url item.
     *
     * @param jumpUrl the jump url
     * @return the item
     */
    public Item jumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
        return this;
    }
}