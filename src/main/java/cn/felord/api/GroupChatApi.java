package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.externalcontact.GroupChatDetail;
import cn.felord.domain.externalcontact.GroupChatDetailRequest;
import cn.felord.domain.externalcontact.GroupChatListRequest;
import cn.felord.domain.externalcontact.GroupChatListResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

/**
 * 客户群管理
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public class GroupChatApi extends AbstractApi {
    /**
     * Instantiates a new On transfer api.
     *
     * @param cacheable the cacheable
     */
    GroupChatApi(WeComCacheable cacheable) {
        super(cacheable);
    }

    /**
     * Agent on transfer api.
     *
     * @param agent the agent
     * @return the on transfer api
     */
    GroupChatApi agent(AgentDetails agent) {
        this.withAgent(agent);
        return this;
    }

    /**
     * 获取客户群列表
     *
     * @param request the request
     * @return the transfer result response
     */
    public GroupChatListResponse groupChatList(GroupChatListRequest request) {

        String endpoint = WeComEndpoint.GROUP_CHAT_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, GroupChatListResponse.class);
    }

    /**
     * 获取客户群详情
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the group chat detail
     */
    public <R extends GroupChatDetailRequest> GenericResponse<GroupChatDetail> getGroupChatDetail(R request) {

        String endpoint = WeComEndpoint.GROUP_CHAT_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<GroupChatDetail>>() {
        });
    }

    public GenericResponse<String> opengidToChatid(String opengid) {

        String endpoint = WeComEndpoint.GROUP_CHAT_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("opengid", opengid), new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }
}
