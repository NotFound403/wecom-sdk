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
import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.jssdk.AgentConfigResponse;
import cn.felord.domain.jssdk.CorpConfigResponse;
import cn.felord.domain.jssdk.JSignatureResponse;
import cn.felord.enumeration.WeComEndpoint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.Assert;
import org.springframework.util.IdGenerator;
import org.springframework.util.LinkedMultiValueMap;

import java.security.MessageDigest;
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
    private final IdGenerator nonceStrGenerator = new AlternativeJdkIdGenerator();
    private final WorkWeChatApiClient workWeChatApiClient;
    private final AgentDetails agentDetails;
    private final WeComAgentTicketCacheable cacheable;

    SdkTicketApi(WorkWeChatApiClient workWeChatApiClient, WeComAgentTicketCacheable cacheable) {
        this.workWeChatApiClient = workWeChatApiClient;
        this.agentDetails = workWeChatApiClient.getAgentDetails();
        this.cacheable = cacheable;
    }

    /**
     * Corp ticket js ticket response.
     *
     * @param url the url
     * @return the js ticket response
     */
    public CorpConfigResponse corpTicket(String url) {
        String corpTicket = this.corpTicket();
        JSignatureResponse jSignatureResponse = this.sha1(corpTicket, url);
        CorpConfigResponse corpConfigResponse = new CorpConfigResponse();
        corpConfigResponse.setAppId(agentDetails.getCorpId());
        corpConfigResponse.setNonceStr(jSignatureResponse.getNonceStr());
        corpConfigResponse.setTimestamp(jSignatureResponse.getTimestamp());
        corpConfigResponse.setSignature(jSignatureResponse.getSignature());
        return corpConfigResponse;
    }

    /**
     * Agent ticket js ticket response.
     *
     * @param url the url
     * @return the js ticket response
     */
    public AgentConfigResponse agentTicket(String url) {
        String agentId = agentDetails.getAgentId();
        Assert.notNull(agentId, "agentId must not be null");
        String agentTicket = this.agentTicket();
        JSignatureResponse jSignatureResponse = this.sha1(agentTicket, url);
        AgentConfigResponse agentConfigResponse = new AgentConfigResponse();
        agentConfigResponse.setCorpid(agentDetails.getCorpId());
        agentConfigResponse.setAgentid(agentId);
        agentConfigResponse.setNonceStr(jSignatureResponse.getNonceStr());
        agentConfigResponse.setTimestamp(jSignatureResponse.getTimestamp());
        agentConfigResponse.setSignature(jSignatureResponse.getSignature());
        return agentConfigResponse;
    }

    private String corpTicket() {
        String corpId = this.agentDetails.getCorpId();
        String agentId = this.agentDetails.getAgentId();
        String ticket = cacheable.getCorpTicket(corpId, agentId);
        if (ticket == null) {
            synchronized (this) {
                ticket = cacheable.getCorpTicket(corpId, agentId);
                if (ticket == null) {
                    JsTicketResponse jsTicketResponse = workWeChatApiClient.get(WeComEndpoint.CORP_JSAPI_TICKET, JsTicketResponse.class);
                    if (jsTicketResponse.isError() || jsTicketResponse.getTicket() == null) {
                        throw new WeComException(jsTicketResponse.getErrcode(), jsTicketResponse.getErrmsg());
                    }
                    ticket = cacheable.putCorpTicket(corpId, agentId, jsTicketResponse.ticket);
                }
            }
        }
        return ticket;
    }

    private String agentTicket() {
        String corpId = this.agentDetails.getCorpId();
        String agentId = this.agentDetails.getAgentId();
        String ticket = cacheable.getAgentTicket(corpId, agentId);
        if (ticket == null) {
            synchronized (this) {
                ticket = cacheable.getAgentTicket(corpId, agentId);
                if (ticket == null) {
                    LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
                    query.add("type", "agent_config");
                    JsTicketResponse jsTicketResponse = workWeChatApiClient.get(WeComEndpoint.AGENT_JSAPI_TICKET, query, JsTicketResponse.class);
                    if (jsTicketResponse.isError() || jsTicketResponse.getTicket() == null) {
                        throw new WeComException("fail to obtain the agent ticket");
                    }
                    ticket = cacheable.putAgentTicket(corpId, agentId, jsTicketResponse.ticket);
                }
            }
        }
        return ticket;
    }

    @SneakyThrows
    private JSignatureResponse sha1(String ticket, String url) {
        String nonceStr = nonceStrGenerator.generateId()
                .toString()
                .replaceAll("-", "");
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String format = MessageFormat.format(SIGNATURE_FORMATTER, ticket, nonceStr, timestamp, url);
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(format.getBytes());
        byte[] bytes = digest.digest();
        String signature = encodeHexString(bytes);
        JSignatureResponse jSignature = new JSignatureResponse();

        jSignature.setNonceStr(nonceStr);
        jSignature.setTimestamp(timestamp);
        jSignature.setSignature(signature);

        return jSignature;
    }


    /**
     * The type Js ticket response.
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    static class JsTicketResponse extends WeComResponse {
        private String ticket;
        private Integer expiresIn;
    }

    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'};


    public static String encodeHexString(final byte[] data) {
        return new String(encodeHex(data));
    }


    protected static char[] encodeHex(final byte[] data) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return out;
    }
}
