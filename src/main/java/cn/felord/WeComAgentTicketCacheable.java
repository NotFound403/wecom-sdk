package cn.felord;

import org.springframework.lang.NonNull;

/**
 * Ticket 缓存
 *
 * @author felord.cn
 */
public interface WeComAgentTicketCacheable extends WeComCacheable {

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
    String putCorpTicket(@NonNull String corpId, @NonNull String agentId, @NonNull String corpTicket);

    /**
     * 获取企业的jsapi_ticket.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the corpTicket
     */
    String getCorpTicket(@NonNull String corpId, @NonNull String agentId);

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
    String putAgentTicket(@NonNull String corpId, @NonNull String agentId, @NonNull String agentTicket);

    /**
     * 获取应用的jsapi_ticket.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the agentTicket
     */
    String getAgentTicket(@NonNull String corpId, @NonNull String agentId);

}
