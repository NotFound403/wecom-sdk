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
import cn.felord.WeComException;
import cn.felord.WeComTokenCacheable;
import cn.felord.domain.authentication.AccessTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 获取 access_token
 *
 * @author felord.cn
 */
public class AccessTokenApi extends AbstractTokenApi {

    /**
     * Instantiates a new Access token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    AccessTokenApi(WeComTokenCacheable wecomCacheable, AgentDetails agentDetails) {
        super(wecomCacheable, agentDetails);
    }

    @Override
    protected String doGetToken(AgentDetails agentDetails) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.GET_TOKEN.endpoint())
                .queryParam("corpid", agentDetails.getCorpId())
                .queryParam("corpsecret", agentDetails.getSecret())
                .build();
        AccessTokenResponse tokenResponse = this.getRestTemplate().getForObject(uriComponents.toUri(), AccessTokenResponse.class);
        if (tokenResponse == null || tokenResponse.isError()) {
            String errorMsg = tokenResponse == null ? "token response is null" : tokenResponse.getErrmsg();
            throw new WeComException("failed to obtain access token,reason: " + errorMsg);
        }
        return tokenResponse.getAccessToken();
    }
}
