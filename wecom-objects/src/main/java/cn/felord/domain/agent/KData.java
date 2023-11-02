package cn.felord.domain.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/5/27 10:23
 */
@ToString
@Getter
public class KData {
    private final String data;
    private String pagepath;
    private String jumpUrl;
    private String key;


    @JsonCreator
    KData(@JsonProperty("data") String data,
          @JsonProperty("pagepath") String pagepath,
          @JsonProperty("jump_url") String jumpUrl,
          @JsonProperty("key") String key) {
        this.data = data;
        this.pagepath = pagepath;
        this.jumpUrl = jumpUrl;
        this.key = key;
    }

    public KData(String data) {
        this.data = data;
    }

    public KData pagepath(String pagepath) {
        this.pagepath = pagepath;
        return this;
    }

    public KData jumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
        return this;
    }

    public KData key(String key) {
        this.key = key;
        return this;
    }
}