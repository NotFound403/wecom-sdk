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
import java.util.Collections;

/**
 * 客户群管理
 *
 * @author dax
 * @since 2021/9/14 13:59
 */
public class GroupChatApi extends AbstractAgentApi {
    /**
     * Instantiates a new On transfer api.
     *
     * @param cacheable the cacheable
     */
    GroupChatApi(WeComCacheable wecomCacheable,AgentDetails agent) {
        super(wecomCacheable,agent);
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

    /**
     * 客户群opengid转换
     *
     * @param opengid the opengid
     * @return the generic response
     */
    public GenericResponse<String> opengidToChatid(String opengid) {

        String endpoint = WeComEndpoint.OPENGID_TO_CHATID.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("opengid", opengid), new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 配置客户群进群方式
     *
     * @param body the body
     * @return the generic response
     */
    public GenericResponse<String> addGroupChatWay(GroupChatWayBody body) {

        String endpoint = WeComEndpoint.GROUP_CHAT_ADD_JOIN_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, body, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 获取客户群进群方式配置
     *
     * @param configId the config id
     * @return the contact way
     */
    public GenericResponse<GroupChatWayResponse> getGroupChatWay(String configId) {
        String endpoint = WeComEndpoint.GROUP_CHAT_GET_JOIN_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("config_id", configId),
                new ParameterizedTypeReference<GenericResponse<GroupChatWayResponse>>() {
                });
    }

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 更新客户群进群方式配置
     *
     * @param body the body
     * @return the we com response
     */
    public WeComResponse updateGroupChatWay(MutableGroupChatWayBody body) {
        String endpoint = WeComEndpoint.GROUP_CHAT_UPDATE_JOIN_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, body,
                WeComResponse.class);
    }

    /**
     * 客户群「加入群聊」管理
     * <p>
     * 删除客户群进群方式配置
     *
     * @param configId the config id
     * @return the we com response
     */
    public WeComResponse delGroupChatWay(String configId) {
        String endpoint = WeComEndpoint.GROUP_CHAT_DEL_JOIN_WAY.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, Collections.singletonMap("config_id", configId), WeComResponse.class);
    }
}
