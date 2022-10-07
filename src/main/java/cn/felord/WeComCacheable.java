package cn.felord;

import org.springframework.lang.NonNull;

/**
 * The interface Cacheable.
 *
 * @author felord.cn
 */
public interface WeComCacheable {

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

    /**
     * 放入企业的jsapi_ticket.
     * <p>
     * 推荐缓存组织格式 {@code ticket::qywx::corp::{corpId}::{agentId}}.
     *
     * @param corpId     the corpId
     * @param agentId    the agentId
     * @param corpTicket the corpTicket
     * @return the corpTicket
     */
    String putCorpTicket(@NonNull String corpId,@NonNull String agentId, @NonNull String corpTicket);

    /**
     * 获取企业的jsapi_ticket.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the corpTicket
     */
    String getCorpTicket(@NonNull String corpId,@NonNull String agentId);

    /**
     * 放入应用的jsapi_ticket.
     * <p>
     * 推荐缓存组织格式 {@code ticket::qywx::agent::{corpId}::{agentId}}.
     *
     * @param corpId      the corpId
     * @param agentId     the agentId
     * @param agentTicket the agentTicket
     * @return the agentTicket
     */
    String putAgentTicket(@NonNull String corpId,@NonNull String agentId, @NonNull String agentTicket);

    /**
     * 获取应用的jsapi_ticket.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the agentTicket
     */
    String getAgentTicket(@NonNull String corpId,@NonNull String agentId);

}
