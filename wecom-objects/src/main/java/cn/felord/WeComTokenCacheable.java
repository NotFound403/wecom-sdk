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
 * The interface Cacheable.
 *
 * @author felord.cn
 */
public interface WeComTokenCacheable extends WeComAgentTicketCacheable {

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
    String putAccessToken(String corpId, String agentId, String accessToken);

    /**
     * 获取accessToken.
     *
     * @param corpId  the corpId
     * @param agentId the agentId
     * @return the token
     */
    String getAccessToken(String corpId, String agentId);

    /**
     * 清除accessToken
     *
     * @param corpId  the corp id
     * @param agentId the agent id
     */
    void clearAccessToken(String corpId, String agentId);
}
