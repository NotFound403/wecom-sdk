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
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
public class ContactsApi extends AbstractApi {

    public ContactsApi(AgentDetails agentDetails) {
        super(agentDetails);
    }

    public GenericResponse<List<String>> getContactList(String userId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.EX_CONTACTS.endpoint(WeComDomain.CGI_BIN))
                .queryParam("userid", userId)
                .build()
                .toUri();
        return this.weComClient().get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {});
    }

}
