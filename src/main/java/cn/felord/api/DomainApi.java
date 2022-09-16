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
public class DomainApi extends AbstractApi {

    DomainApi(WeComCacheable cacheable) {
        super(cacheable);
    }

    /**
     * With agent contacts api.
     *
     * @param agentDetails the agent details
     * @return the contacts api
     */
    DomainApi agent(AgentDetails agentDetails) {
        this.withAgent(agentDetails);
        return this;
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
