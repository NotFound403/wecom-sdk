package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.TokenCacheable;
import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.jssdk.AgentConfigResponse;
import cn.felord.domain.jssdk.CorpConfigResponse;
import cn.felord.domain.jssdk.JSignatureResponse;
import cn.felord.enumeration.TicketType;
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
 * @author dax
 * @since 1.0.14.RELEASE
 */
public class SdkTicketApi extends AbstractApi {
    private static final String SIGNATURE_FORMATTER = "jsapi_ticket={0}&noncestr={1}&timestamp={2}&url={3}";
    private static final String CORP_TICKET_FORMATTER = "qywx::ticket::corp::{0}::{1}";
    private static final String AGENT_TICKET_FORMATTER = "qywx::ticket::agent::{0}::{1}";
    private final IdGenerator nonceStrGenerator = new AlternativeJdkIdGenerator();
    private AgentDetails agentDetails;
    private final TokenCacheable tokenCacheable;


    /**
     * Instantiates a new We com client.
     *
     * @param tokenCacheable
     */
    SdkTicketApi(TokenCacheable tokenCacheable) {
        super(tokenCacheable);
        this.tokenCacheable = tokenCacheable;
    }

    /**
     * Agent js sdk ticket api.
     *
     * @param agentDetails the agent details
     * @return the js sdk ticket api
     */
    SdkTicketApi agent(AgentDetails agentDetails) {
        this.withAgent(agentDetails);
        this.agentDetails = agentDetails;
        return this;
    }

    /**
     * Corp ticket js ticket response.
     *
     * @return the js ticket response
     */
    public CorpConfigResponse corpTicket(String url) {
        String corpTicket = this.ticket(CORP_TICKET_FORMATTER, WeComEndpoint.CORP_JSAPI_TICKET, null);

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
     * @return the js ticket response
     */
    public AgentConfigResponse agentTicket(String url) {
        String agentId = agentDetails.getAgentId();
        Assert.notNull(agentId, "agentId must not be null");
        String agentTicket = this.ticket(AGENT_TICKET_FORMATTER, WeComEndpoint.AGENT_JSAPI_TICKET, TicketType.AGENT_CONFIG);
        JSignatureResponse jSignatureResponse = this.sha1(agentTicket, url);
        AgentConfigResponse agentConfigResponse = new AgentConfigResponse();
        agentConfigResponse.setCorpid(agentDetails.getCorpId());
        agentConfigResponse.setAgentid(agentId);
        agentConfigResponse.setNonceStr(jSignatureResponse.getNonceStr());
        agentConfigResponse.setTimestamp(jSignatureResponse.getTimestamp());
        agentConfigResponse.setSignature(jSignatureResponse.getSignature());
        return agentConfigResponse;
    }

    private String ticket(String formatter, WeComEndpoint weComEndpoint, TicketType ticketType) {
        String key = MessageFormat.format(formatter, this.agentDetails.getCorpId(), this.agentDetails.getAgentId());
        String ticket = tokenCacheable.get(key);
        if (ticket == null) {
            String endpoint = weComEndpoint.endpoint();
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(endpoint);
            if (ticketType != null) {
                uriComponentsBuilder.queryParam("type", ticketType.type());
            }
            URI uri = uriComponentsBuilder
                    .build()
                    .toUri();
            JsTicketResponse jsTicketResponse = this.get(uri, JsTicketResponse.class);
            if (!jsTicketResponse.isSuccessful() || jsTicketResponse.getTicket() == null) {
                throw new WeComException("fail to obtain the ticket");
            }
            ticket = jsTicketResponse.ticket;
            tokenCacheable.put(key, ticket);
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


    @EqualsAndHashCode(callSuper = true)
    @Data
    static class JsTicketResponse extends WeComResponse {
        private String ticket;
        private Integer expiresIn;
    }
}
