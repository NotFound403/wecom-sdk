package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.Cacheable;
import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.jssdk.JSignature;
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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.time.Instant;

/**
 * The type Js sdk ticket api.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class SdkTicketApi extends AbstractApi {
    private static final String SIGNATURE_FORMATTER = "jsapi_ticket={0}&noncestr={1}&timestamp={2}&url={3}";
    private static final String CORP_TICKET_FORMATTER = "qywx::ticket::corp::{0}::{1}";
    private static final String AGENT_TICKET_FORMATTER = "qywx::ticket::agent::{0}::{1}";
    private final IdGenerator nonceStrGenerator = new AlternativeJdkIdGenerator();
    private AgentDetails agentDetails;
    private final Cacheable cacheable;


    /**
     * Instantiates a new We com client.
     *
     * @param cacheable
     */
    SdkTicketApi(Cacheable cacheable) {
        super(cacheable);
        this.cacheable = cacheable;
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
    public JSignature corpTicket(String url) {
        String corpTicket = ticket(CORP_TICKET_FORMATTER, WeComEndpoint.CORP_JSAPI_TICKET);
        return this.sha1(corpTicket, url);
    }

    /**
     * Agent ticket js ticket response.
     *
     * @return the js ticket response
     */
    public JSignature agentTicket(String url) {
        String agentId = agentDetails.getAgentId();
        Assert.notNull(agentId, "agentId must not be null");
        String agentTicket = ticket(AGENT_TICKET_FORMATTER, WeComEndpoint.AGENT_JSAPI_TICKET);
        JSignature jSignature = this.sha1(agentTicket, url);
        jSignature.setAgentId(agentId);
        return jSignature;
    }

    private String ticket(String formatter, WeComEndpoint weComEndpoint) {
        String key = MessageFormat.format(formatter, this.agentDetails.getCorpId(), this.agentDetails.getAgentId());
        String ticket = cacheable.get(key);
        if (ticket == null) {
            String endpoint = weComEndpoint.endpoint();
            URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                    .build()
                    .toUri();
            JsTicketResponse jsTicketResponse = this.get(uri, JsTicketResponse.class);
            if (!jsTicketResponse.isSuccessful() || jsTicketResponse.getTicket() == null) {
                throw new WeComException("fail to obtain the ticket");
            }
            ticket = jsTicketResponse.ticket;
            cacheable.put(key, ticket);
        }

        return ticket;
    }

    @SneakyThrows
    private JSignature sha1(String ticket, String url) {
        String nonceStr = nonceStrGenerator.generateId()
                .toString()
                .replaceAll("-", "");

        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String format = MessageFormat.format(SIGNATURE_FORMATTER, ticket, nonceStr, timestamp, url);
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(format.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = digest.digest();
        String signature = Hex.encodeHexString(bytes);

        JSignature jSignature = new JSignature();

        jSignature.setNoncestr(nonceStr);
        jSignature.setTimestamp(timestamp);
        jSignature.setSignature(signature);
        jSignature.setUrl(url);
        return jSignature;

    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    static class JsTicketResponse extends WeComResponse {
        private String ticket;
        private Integer expiresIn;
    }
}
