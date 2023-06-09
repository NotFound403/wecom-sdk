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
import cn.felord.WeComAgentTicketCacheable;
import cn.felord.domain.authentication.JsTicketResponse;
import cn.felord.domain.jssdk.AgentConfigResponse;
import cn.felord.domain.jssdk.CorpConfigResponse;
import cn.felord.domain.jssdk.JSignatureResponse;
import cn.felord.utils.AlternativeJdkIdGenerator;
import cn.felord.utils.SHA1;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.SneakyThrows;

import java.text.MessageFormat;
import java.time.Instant;

/**
 * The type Js sdk ticket api.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class SdkTicketApi {
    private static final String SIGNATURE_FORMATTER = "jsapi_ticket={0}&noncestr={1}&timestamp={2}&url={3}";
    private static final AlternativeJdkIdGenerator ID_GENERATOR = new AlternativeJdkIdGenerator();
    private final AgentDetails agentDetails;
    private final JsApi jsApi;
    private final WeComAgentTicketCacheable weComAgentTicketCacheable;

    SdkTicketApi(WorkWeChatApiClient workWeChatApiClient, WeComAgentTicketCacheable weComAgentTicketCacheable) {
        this.agentDetails = workWeChatApiClient.agentDetails();
        this.jsApi = workWeChatApiClient.retrofit().create(JsApi.class);
        this.weComAgentTicketCacheable = weComAgentTicketCacheable;

    }

    /**
     * Corp ticket js ticket response.
     *
     * @param url the url
     * @return the js ticket response
     */
    public Single<CorpConfigResponse> corpTicket(String url) {
        String corpId = agentDetails.getCorpId();
        String agentId = agentDetails.getAgentId();
        return Maybe.just(weComAgentTicketCacheable.getCorpTicket(corpId, agentId))
                .switchIfEmpty(jsApi.corpJsApiTicket()
                        .map(JsTicketResponse::getTicket)
                        .map(corpTicket -> weComAgentTicketCacheable.putCorpTicket(corpId, agentId, corpTicket)))
                .map(corpTicket -> {
                    JSignatureResponse jSignatureResponse = this.sha1(corpTicket, url);
                    CorpConfigResponse corpConfigResponse = new CorpConfigResponse();
                    corpConfigResponse.setAppId(agentDetails.getCorpId());
                    corpConfigResponse.setNonceStr(jSignatureResponse.getNonceStr());
                    corpConfigResponse.setTimestamp(jSignatureResponse.getTimestamp());
                    corpConfigResponse.setSignature(jSignatureResponse.getSignature());
                    return corpConfigResponse;
                });
    }

    /**
     * Agent ticket js ticket response.
     *
     * @param url the url
     * @return the js ticket response
     */
    public Single<AgentConfigResponse> agentTicket(String url) {
        String corpId = agentDetails.getCorpId();
        String agentId = agentDetails.getAgentId();
        return Maybe.just(weComAgentTicketCacheable.getCorpTicket(corpId, agentId))
                .switchIfEmpty(jsApi.agentJsApiTicket("agent_config")
                        .map(JsTicketResponse::getTicket)
                        .map(agentTicket -> weComAgentTicketCacheable.putAgentTicket(corpId, agentId, agentTicket)))
                .map(agentTicket -> {
                    JSignatureResponse jSignatureResponse = this.sha1(agentTicket, url);
                    AgentConfigResponse agentConfigResponse = new AgentConfigResponse();
                    agentConfigResponse.setCorpid(corpId);
                    agentConfigResponse.setAgentid(agentId);
                    agentConfigResponse.setNonceStr(jSignatureResponse.getNonceStr());
                    agentConfigResponse.setTimestamp(jSignatureResponse.getTimestamp());
                    agentConfigResponse.setSignature(jSignatureResponse.getSignature());
                    return agentConfigResponse;
                });
    }


    @SneakyThrows
    private JSignatureResponse sha1(String ticket, String url) {
        String nonceStr = ID_GENERATOR.generateId();
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String format = MessageFormat.format(SIGNATURE_FORMATTER, ticket, nonceStr, timestamp, url);
        JSignatureResponse jSignature = new JSignatureResponse();
        jSignature.setNonceStr(nonceStr);
        jSignature.setTimestamp(timestamp);
        jSignature.setSignature(SHA1.sha1Hex(format));
        return jSignature;
    }
}
