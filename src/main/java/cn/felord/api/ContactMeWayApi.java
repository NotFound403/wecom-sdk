package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

/**
 * The type Corp service user api.
 *
 * @author dax
 * @since 2021 /9/8 9:28
 */
public class ContactMeWayApi extends AbstractApi {
    /**
     * Instantiates a new Corp service user api.
     *
     * @param cacheable the cacheable
     */
    ContactMeWayApi(WeComCacheable cacheable) {
        super(cacheable);
    }

    /**
     * Agent corp service user api.
     *
     * @param agent the agent
     * @return the corp service user api
     */
    ContactMeWayApi agent(AgentDetails agent) {
        this.withAgent(agent);
        return this;
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
        return this.get(uri, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
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
        return this.post(uri, request, ContactWayAddResponse.class);
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
        return this.post(uri, Collections.singletonMap("config_id", configId),
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
        return this.post(uri, request, ContactListResponse.class);
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
        return this.post(uri, contactWay, WeComResponse.class);
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
        return this.post(uri, Collections.singletonMap("config_id", configId), WeComResponse.class);
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
        return this.post(uri, body, WeComResponse.class);
    }
}
