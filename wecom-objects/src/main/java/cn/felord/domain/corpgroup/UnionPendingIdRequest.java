package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Corp ex user request.
 *
 * @author dax
 * @since 2023 /10/12
 */
@ToString
@Getter
public class UnionPendingIdRequest {
    /**
     * 微信客户的unionid
     */
    private final String unionid;
    /**
     * 微信客户的openid
     */
    private final String openid;

    /**
     * Instantiates a new Corp ex user request.
     *
     * @param unionid the unionid
     * @param openid  the openid
     */
    public UnionPendingIdRequest(String unionid, String openid) {
        this.unionid = unionid;
        this.openid = openid;
    }
}
