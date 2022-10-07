package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.jssdk.AgentConfigResponse;
import cn.felord.domain.jssdk.CorpConfigResponse;
import cn.felord.domain.jssdk.JSignatureResponse;
import cn.felord.enumeration.WeComEndpoint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Hex;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.Assert;
import org.springframework.util.IdGenerator;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    private final WeComCacheable cacheable;

    public SdkTicketApi(WorkWeChatApiClient workWeChatApiClient, AgentDetails agentDetails, WeComCacheable cacheable) {
        this.workWeChatApiClient = workWeChatApiClient;
        this.agentDetails = agentDetails;
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
                    URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.CORP_JSAPI_TICKET.endpoint())
                            .build()
                            .toUri();
                    JsTicketResponse jsTicketResponse = workWeChatApiClient.get(uri, JsTicketResponse.class);
                    if (jsTicketResponse.isError() || jsTicketResponse.getTicket() == null) {
                        throw new WeComException("fail to obtain the corp ticket");
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
                    URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.AGENT_JSAPI_TICKET.endpoint())
                            .queryParam("type", "agent_config")
                            .build()
                            .toUri();
                    JsTicketResponse jsTicketResponse = workWeChatApiClient.get(uri, JsTicketResponse.class);
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
        String signature = Hex.encodeHexString(bytes);
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
}
