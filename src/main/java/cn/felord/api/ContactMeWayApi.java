package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Corp service user api.
 *
 * @author dax
 * @since 2021 /9/8 9:28
 */
public class ContactMeWayApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Contact me way api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ContactMeWayApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取配置了客户联系功能的成员列表
     *
     * @return the follow user list
     */
    public GenericResponse<List<String>> getFollowUserList() {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_FOLLOW_USER_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }

    /**
     * 配置客户联系「联系我」方式
     *
     * @param request the request
     * @return the we com response
     */
    public ContactWayAddResponse addContactWay(ContactWayBody request) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_ADD_CONTACT_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, ContactWayAddResponse.class);
    }

    /**
     * 获取企业已配置的「联系我」方式
     *
     * @param configId the config id
     * @return the we com response
     */
    public GenericResponse<ContactWayBodyDetail> getContactWay(String configId) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_GET_CONTACT_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("config_id", configId),
                new ParameterizedTypeReference<GenericResponse<ContactWayBodyDetail>>() {
                });
    }

    /**
     * 获取企业已配置的「联系我」列表
     *
     * @param request the request
     * @return the we com response
     */
    public ContactListResponse listContactWay(ContactListRequest request) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_LIST_CONTACT_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, ContactListResponse.class);
    }

    /**
     * 更新企业已配置的「联系我」方式
     *
     * @param contactWay the contact way
     * @return the we com response
     */
    public WeComResponse updateContactWay(MutableContactWay contactWay) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_UPDATE_CONTACT_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, contactWay, WeComResponse.class);
    }

    /**
     * 删除企业已配置的「联系我」方式
     *
     * @param configId the config id
     * @return the we com response
     */
    public WeComResponse delContactWay(String configId) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_DEL_CONTACT_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("config_id", configId), WeComResponse.class);
    }

    /**
     * 结束临时会话
     *
     * @param userid         the userid
     * @param externalUserid the external userid
     * @return the we com response
     */
    public WeComResponse closeTempChat(String userid, String externalUserid) {
        String endpoint = WeComEndpoint.EXTERNALCONTACT_CLOSE_TEMP_CHAT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, String> body = new HashMap<>(2);
        body.put("userid", userid);
        body.put("external_userid", externalUserid);
        return workWeChatApiClient.post(uri, body, WeComResponse.class);
    }
}
