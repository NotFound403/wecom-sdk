package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.domain.GenericResponse;
import cn.felord.enumeration.WeComDomain;
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
public class ContactsApi extends AbstractApi {

    /**
     * With agent contacts api.
     *
     * @param agentDetails the agent details
     * @return the contacts api
     */
    public ContactsApi agent(AgentDetails agentDetails) {
        this.withAgent(agentDetails);
        return this;
    }

    /**
     * Gets contact list.
     *
     * @param userId the user id
     * @return the contact list
     */
    public GenericResponse<List<String>> getContactList(String userId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.EX_CONTACTS.endpoint(WeComDomain.CGI_BIN))
                .queryParam("userid", userId)
                .build()
                .toUri();
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }

}
