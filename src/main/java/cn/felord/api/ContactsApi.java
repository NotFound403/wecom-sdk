package cn.felord.api;

import cn.felord.domain.customer.ExternalContactResponse;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
public class ContactsApi extends AbstractApi {
    public ContactsApi() {
        super(UriComponentsBuilder.fromHttpUrl(WeComEndpoint.EX_CONTACTS.endpoint(WeComDomain.CGI_BIN)));
    }


    public ExternalContactResponse getContactList(String userId) {
        URI uri = this.getUriComponentsBuilder().queryParam("userid", userId)
                .build()
                .toUri();
        return this.getWeComClient().get(uri, ExternalContactResponse.class);
    }

}
