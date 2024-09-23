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

package cn.felord.retrofit;


import cn.felord.AgentDetails;
import cn.felord.WeComTokenCacheable;

/**
 * The type Token api.
 *
 * @author dax
 * @since 2021 /10/7 15:19
 */
public abstract class AbstractTokenApi implements TokenApi {
    private final WeComTokenCacheable wecomCacheable;
    private final AgentDetails agentDetails;

    /**
     * Instantiates a new Token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    protected AbstractTokenApi(WeComTokenCacheable wecomCacheable, AgentDetails agentDetails) {
        this.wecomCacheable = wecomCacheable;
        this.agentDetails = agentDetails;
    }

    /**
     * Gets token response.
     *
     * @return the token response
     */
    @Override
    public final String getToken() {
        String corpId = agentDetails.getCorpId();
        final String agentId = agentDetails.getAgentId();
        String tokenCache = wecomCacheable.getAccessToken(corpId, agentId);
        if (tokenCache == null) {
            synchronized (this) {
                tokenCache = wecomCacheable.getAccessToken(corpId, agentId);
                if (tokenCache == null) {
                    tokenCache = wecomCacheable.putAccessToken(corpId, agentId, doGetToken(agentDetails));
                }
            }
        }
        return tokenCache;
    }

    @Override
    public WeComTokenCacheable getWecomCacheable() {
        return wecomCacheable;
    }

    @Override
    public AgentDetails getAgentDetails() {
        return agentDetails;
    }

    @Override
    public void clearToken() {
        wecomCacheable.clearAccessToken(agentDetails.getCorpId(), agentDetails.getAgentId());
    }

    /**
     * Do get token string.
     *
     * @param agentDetails the agent details
     * @return the string
     */
    protected abstract String doGetToken(AgentDetails agentDetails);

}
