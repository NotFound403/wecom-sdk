/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.wecom.cache;

import cn.felord.WeComTokenCacheable;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
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

    @CacheEvict(value = {QYWX_TOKEN_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    @Override
    public void clearAccessToken(String corpId, String agentId) {

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

