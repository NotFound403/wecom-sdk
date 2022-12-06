package cn.felord.domain.externalcontact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/5/18 16:08
 */
@ToString
@Getter
public class Miniprogram {
    private final String title;
    private final String picMediaId;
    private final String appid;
    private final String page;

    @JsonCreator
    public Miniprogram(@JsonProperty("title") String title, @JsonProperty("pic_media_id") String picMediaId, @JsonProperty("appid") String appid, @JsonProperty("page") String page) {
        this.title = title;
        this.picMediaId = picMediaId;
        this.appid = appid;
        this.page = page;
    }
}
