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
import cn.felord.DownStreamDetails;
import cn.felord.WeComException;
import cn.felord.WeComTokenCacheable;
import cn.felord.domain.authentication.AccessTokenResponse;

/**
 * 获取下级/下游企业的access_token
 *
 * @author dax
 * @since 2024/10/12
 */
public class DownStreamTokenApi extends AbstractTokenApi {

    private static final DownStreamAccessTokenApi DOWNSTREAM_TOKEN_API = WorkWechatRetrofitFactory.RETROFIT_.create(DownStreamAccessTokenApi.class);

    /**
     * Instantiates a new Token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agentDetails   the agent details
     */
    public DownStreamTokenApi(WeComTokenCacheable wecomCacheable, DownStreamDetails agentDetails) {
        super(wecomCacheable, agentDetails);
    }

    @Override
    protected String doGetToken(AgentDetails agentDetails) {
        DownStreamDetails downStreamDetails = (DownStreamDetails) agentDetails;
        AccessTokenApi tokenApi = new AccessTokenApi(this.getWecomCacheable(), downStreamDetails.getUpStreamDetails());
        String token = tokenApi.getToken();
        AccessTokenResponse tokenResponse = DOWNSTREAM_TOKEN_API.getTokenResponse(WecomUserAgent.WECOM_USER_AGENT, downStreamDetails.toRequest(), token);
        if (tokenResponse == null || tokenResponse.isError()) {
            String errorMsg = tokenResponse == null ? "downstream token response is null" : tokenResponse.getErrmsg();
            throw new WeComException("failed to obtain downstream access token,reason: " + errorMsg);
        }
        return tokenResponse.getAccessToken();
    }
}
