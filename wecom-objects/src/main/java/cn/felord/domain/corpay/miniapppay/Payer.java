package cn.felord.domain.corpay.miniapppay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@ToString
@Getter
public class Payer {
    private final String openid;

    /**
     * Instantiates a new Payer.
     *
     * @param openid the openid
     */
    @JsonCreator
    public Payer(@JsonProperty("openid") String openid) {
        this.openid = openid;
    }
}