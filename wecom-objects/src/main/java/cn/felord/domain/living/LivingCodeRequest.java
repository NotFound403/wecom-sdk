package cn.felord.domain.living;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Living code request.
 *
 * @author dax
 * @since 2023 /11/23
 */
@ToString
@Getter
public class LivingCodeRequest {
    /**
     * 直播id
     */
    private final String livingid;
    /**
     * 微信用户的openid
     */
    private final String openid;

    /**
     * Instantiates a new Living code request.
     *
     * @param livingid the livingid
     * @param openid   the openid
     */
    public LivingCodeRequest(String livingid, String openid) {
        this.livingid = livingid;
        this.openid = openid;
    }
}
