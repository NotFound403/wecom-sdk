package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.GenericResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * The type Contacts api.
 *
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
public class DomainApi extends AbstractAgentApi {

    /**
     * Instantiates a new Domain api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agent          the agent
     */
    DomainApi(WeComCacheable wecomCacheable,AgentDetails agent) {
        super(wecomCacheable,agent);
    }

    /**
     * Gets contact list.
     *
     * @return the contact list
     */
    public GenericResponse<List<String>> getApiDomainIp() {
        String endpoint = WeComEndpoint.API_DOMAIN_IP.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }

}
