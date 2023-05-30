package cn.felord.wecom.cache;

import cn.felord.WeComTokenCacheable;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author dax
 * @since 2023/5/30
 */
public class EhcacheWeComTokenCacheable implements WeComTokenCacheable {
    private static final String QYWX_TOKEN_CACHE = "token::qywx";
    private static final String QYWX_CORP_TICKET_CACHE = "ticket::qywx::corp";
    private static final String QYWX_AGENT_TICKET_CACHE = "ticket::qywx::agent";

    @CachePut(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    @Override
    public String putAccessToken(@NotNull String corpId, @NotNull String agentId, @NotNull String accessToken) {
        return accessToken;
    }

    @Cacheable(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    @Override
    public String getAccessToken(@NotNull String corpId, @NotNull String agentId) {
        return null;
    }

    @CachePut(value = {QYWX_CORP_TICKET_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    @Override
    public String putCorpTicket(@NotNull String corpId, @NotNull String agentId, @NotNull String corpTicket) {
        return corpTicket;
    }

    @Cacheable(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    @Override
    public String getCorpTicket(@NotNull String corpId, @NotNull String agentId) {
        return null;
    }

    @CachePut(value = {QYWX_AGENT_TICKET_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    @Override
    public String putAgentTicket(@NotNull String corpId, @NotNull String agentId, @NotNull String agentTicket) {
        return agentTicket;
    }

    @Cacheable(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    @Override
    public String getAgentTicket(@NotNull String corpId, @NotNull String agentId) {
        return null;
    }
}

