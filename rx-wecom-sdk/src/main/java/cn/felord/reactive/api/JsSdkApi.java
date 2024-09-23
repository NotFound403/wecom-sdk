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

package cn.felord.reactive.api;

import cn.felord.AgentDetails;
import cn.felord.WeComAgentTicketCacheable;
import cn.felord.domain.authentication.JsTicketResponse;
import cn.felord.domain.jssdk.AgentConfigResponse;
import cn.felord.domain.jssdk.CorpConfigResponse;
import cn.felord.domain.jssdk.JSignatureResponse;
import cn.felord.domain.jssdk.LaunchCodeRequest;
import cn.felord.domain.jssdk.LaunchCodeResponse;
import cn.felord.utils.Algorithms;
import cn.felord.utils.AlternativeJdkIdGenerator;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

import java.text.MessageFormat;
import java.time.Instant;

/**
 * Js sdk api.
 *
 * @author felord.cn
 * @since 1.0.0
 */
public class JsSdkApi {
    private static final String SIGNATURE_FORMATTER = "jsapi_ticket={0}&noncestr={1}&timestamp={2}&url={3}";
    private static final AlternativeJdkIdGenerator ID_GENERATOR = new AlternativeJdkIdGenerator();
    private final AgentDetails agentDetails;
    private final JsApi jsApi;
    private final WeComAgentTicketCacheable weComAgentTicketCacheable;

    /**
     * Instantiates a new Sdk ticket api.
     *
     * @param workWeChatApiClient       the work we chat api client
     * @param weComAgentTicketCacheable the we com agent ticket cacheable
     */
    JsSdkApi(WorkWeChatApiClient workWeChatApiClient, WeComAgentTicketCacheable weComAgentTicketCacheable) {
        this.agentDetails = workWeChatApiClient.agentDetails();
        this.jsApi = workWeChatApiClient.retrofit().create(JsApi.class);
        this.weComAgentTicketCacheable = weComAgentTicketCacheable;
    }

    /**
     * Corp ticket.
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
     * Agent ticket.
     *
     * @param url the url
     * @return the js ticket response
     */
    public Single<AgentConfigResponse> agentTicket(String url) {
        String corpId = agentDetails.getCorpId();
        String agentId = agentDetails.getAgentId();
        return Maybe.just(weComAgentTicketCacheable.getAgentTicket(corpId, agentId))
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

    /**
     * 打开个人聊天窗口schema
     * <p>
     * 在外部浏览器的web页面上，可通过该schema协议打开个人聊天窗口，目前仅支持windows和mac平台（仅3.1.6及以后版本支持）。
     * 注意这是在外部浏览器web页面的调用方式，不需要引入企业微信的jssdk。
     *
     * @param operatorUserid   the operator userid
     * @param singleChatUserId the single chat user id
     * @return the launch code
     */
    public Single<String> getLaunchCode(String operatorUserid, String singleChatUserId) {
        return jsApi.getLaunchCode(new LaunchCodeRequest(operatorUserid, singleChatUserId))
                .map(LaunchCodeResponse::getLaunchCode)
                .map(launchCode -> "wxwork://launch?launch_code=" + launchCode);
    }


    private JSignatureResponse sha1(String ticket, String url) {
        String nonceStr = ID_GENERATOR.generate32();
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String format = MessageFormat.format(SIGNATURE_FORMATTER, ticket, nonceStr, timestamp, url);
        JSignatureResponse jSignature = new JSignatureResponse();
        jSignature.setNonceStr(nonceStr);
        jSignature.setTimestamp(timestamp);
        jSignature.setSignature(Algorithms.sha1Hex(format));
        return jSignature;
    }
}
