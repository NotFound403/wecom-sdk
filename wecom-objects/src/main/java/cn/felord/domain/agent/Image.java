package cn.felord.domain.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Image.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class Image implements WorkBenchBody {
    private final String url;
    private String pagepath;
    private String jumpUrl;

    /**
     * Instantiates a new Image.
     *
     * @param url      the url
     * @param pagepath the pagepath
     * @param jumpUrl  the jump url
     */
    @JsonCreator
    public Image(@JsonProperty("url") String url,
                 @JsonProperty("pagepath") String pagepath,
                 @JsonProperty("jump_url") String jumpUrl) {
        this.url = url;
        this.pagepath = pagepath;
        this.jumpUrl = jumpUrl;
    }

    /**
     * Instantiates a new Image.
     *
     * @param url the url
     */
    public Image(String url) {
        this.url = url;
    }

    /**
     * Pagepath image.
     *
     * @param pagepath the pagepath
     * @return the image
     */
    public Image pagepath(String pagepath) {
        this.pagepath = pagepath;
        return this;
    }

    /**
     * Jump url image.
     *
     * @param jumpUrl the jump url
     * @return the image
     */
    public Image jumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
        return this;
    }
}