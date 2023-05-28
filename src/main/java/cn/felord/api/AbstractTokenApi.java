/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.RestTemplateFactory;
import cn.felord.WeComTokenCacheable;
import org.springframework.web.client.RestTemplate;

/**
 * The type Token api.
 *
 * @author dax
 * @since 2021 /10/7 15:19
 */
public abstract class AbstractTokenApi implements TokenApi {
    private final WeComTokenCacheable wecomCacheable;
    private final AgentDetails agentDetails;
    private final RestTemplate restTemplate;


    /**
     * Instantiates a new Token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    protected AbstractTokenApi(WeComTokenCacheable wecomCacheable, AgentDetails agentDetails) {
        this.wecomCacheable = wecomCacheable;
        this.agentDetails = agentDetails;
        this.restTemplate = RestTemplateFactory.restOperations();
    }

    /**
     * Gets token response.
     *
     * @return the token response
     */
    @Override
    public final String getTokenResponse() {
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
    public AgentDetails getAgentDetails() {
        return agentDetails;
    }

    /**
     * Gets rest template.
     *
     * @return the rest template
     */
    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * Do get token string.
     *
     * @param agentDetails the agent details
     * @return the string
     */
    protected abstract String doGetToken(AgentDetails agentDetails);

}
