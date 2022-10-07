package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * 获取企业微信服务器IP
 *
 * @author felord.cn
 * @since 2021 /9/11
 */
public class DomainApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Domain api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    DomainApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取企业微信API域名IP段
     *
     * @return the contact list
     */
    public GenericResponse<List<String>> getApiDomainIp() {
        String endpoint = WeComEndpoint.API_DOMAIN_IP.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }

    /**
     * 获取企业微信服务器的ip段
     *
     * @return the api domain ip
     */
    public GenericResponse<List<String>> getCallbackIp() {
        String endpoint = WeComEndpoint.CALLBACK_IP.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }
}
