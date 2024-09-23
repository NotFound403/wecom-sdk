/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord;

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
    String putCorpTicket(String corpId, String agentId, String corpTicket);

    /**
     * 获取企业的jsapi_ticket.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the corpTicket
     */
    String getCorpTicket(String corpId, String agentId);

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
    String putAgentTicket(String corpId, String agentId, String agentTicket);

    /**
     * 获取应用的jsapi_ticket.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the agentTicket
     */
    String getAgentTicket(String corpId, String agentId);

}
