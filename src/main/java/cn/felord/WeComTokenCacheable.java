package cn.felord;

import org.springframework.lang.NonNull;

/**
 * The interface Cacheable.
 *
 * @author felord.cn
 */
public interface WeComTokenCacheable extends WeComCacheable {

    /**
     * 存入accessToken
     * <p>
     * 推荐缓存组织格式 {@code token::qywx::{corpId}::{agentId}}.
     *
     * @param corpId      the corpId
     * @param agentId     the agentId
     * @param accessToken the access token
     * @return the token
     */
    String putAccessToken(@NonNull String corpId, @NonNull String agentId, @NonNull String accessToken);

    /**
     * 获取accessToken.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the token
     */
    String getAccessToken(@NonNull String corpId, @NonNull String agentId);
}
