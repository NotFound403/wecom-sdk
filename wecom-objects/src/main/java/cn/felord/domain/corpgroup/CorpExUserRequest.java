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
public class CorpExUserRequest {
    /**
     * 微信客户的unionid
     */
    private final String unionid;
    /**
     * 微信客户的openid
     */
    private final String openid;
    /**
     * 需要换取的企业corpid，不填则拉取所有企业
     */
    private final String corpid;

    /**
     * Instantiates a new Corp ex user request.
     *
     * @param unionid the unionid
     * @param openid  the openid
     */
    public CorpExUserRequest(String unionid, String openid) {
        this(unionid, openid, null);
    }

    /**
     * Instantiates a new Corp ex user request.
     *
     * @param unionid the unionid
     * @param openid  the openid
     * @param corpid  the corpid
     */
    public CorpExUserRequest(String unionid, String openid, String corpid) {
        this.unionid = unionid;
        this.openid = openid;
        this.corpid = corpid;
    }
}
