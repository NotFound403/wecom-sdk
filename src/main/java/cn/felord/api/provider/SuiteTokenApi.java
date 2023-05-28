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

package cn.felord.api.provider;

import cn.felord.*;
import cn.felord.api.TokenApi;
import cn.felord.domain.authentication.SuiteTokenResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 获取第三方应用凭证
 *
 * @author felord.cn
 */
public class SuiteTokenApi implements TokenApi {
    private static final String SUITE_KEY = "suite";
    private final WeComTokenCacheable wecomCacheable;
    private final SuiteDetail suiteDetail;
    private final RestTemplate restTemplate;


    /**
     * Instantiates a new Token api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param suiteDetail    the suite detail
     */
    protected SuiteTokenApi(WeComTokenCacheable wecomCacheable, SuiteDetail suiteDetail) {
        this.wecomCacheable = wecomCacheable;
        this.suiteDetail = suiteDetail;
        this.restTemplate = RestTemplateFactory.restOperations();
    }

    @Override
    public final String getTokenResponse() {
        String corpId = suiteDetail.getSuiteId();

        String tokenCache = wecomCacheable.getAccessToken(corpId, SUITE_KEY);
        if (tokenCache == null) {
            synchronized (this) {
                tokenCache = wecomCacheable.getAccessToken(corpId, SUITE_KEY);
                if (tokenCache == null) {
                    UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.SERVICE_GET_SUITE_TOKEN.endpoint())
                            .build();

                    SuiteTokenResponse tokenResponse = this.restTemplate.postForObject(uriComponents.toUri(), suiteDetail, SuiteTokenResponse.class);
                    if (tokenResponse == null || tokenResponse.isError()) {
                        throw new WeComException("failed to obtain suite token");
                    }
                    tokenCache = wecomCacheable.putAccessToken(corpId, SUITE_KEY, tokenResponse.getSuiteAccessToken());
                }
            }
        }
        return tokenCache;
    }

    @Override
    public AgentDetails getAgentDetails() {
        throw new IllegalArgumentException("not support");
    }
}
