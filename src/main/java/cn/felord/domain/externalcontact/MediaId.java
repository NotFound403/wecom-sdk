package cn.felord.domain.externalcontact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/11/22 15:01
 */
@ToString
@Getter
public class MediaId {
    private final String mediaId;

    @JsonCreator
    public MediaId(@JsonProperty("media_id") String mediaId) {
        this.mediaId = mediaId;
    }
}
