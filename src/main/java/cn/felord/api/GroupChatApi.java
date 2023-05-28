/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.GroupChatDetail;
import cn.felord.domain.externalcontact.GroupChatDetailRequest;
import cn.felord.domain.externalcontact.GroupChatListRequest;
import cn.felord.domain.externalcontact.GroupChatListResponse;
import cn.felord.domain.externalcontact.GroupChatWayBody;
import cn.felord.domain.externalcontact.GroupChatWayResponse;
import cn.felord.domain.externalcontact.MutableGroupChatWayBody;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;

/**
 * 客户群管理
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public class GroupChatApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Group chat api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    GroupChatApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取客户群列表
     *
     * @param request the request
     * @return the transfer result response
     */
    public GroupChatListResponse groupChatList(GroupChatListRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_CHAT_LIST, request, GroupChatListResponse.class);
    }

    /**
     * 获取客户群详情
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the group chat detail
     */
    public <R extends GroupChatDetailRequest> GenericResponse<GroupChatDetail> getGroupChatDetail(R request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_CHAT_GET, request, new ParameterizedTypeReference<GenericResponse<GroupChatDetail>>() {
        });
    }

    /**
     * 客户群opengid转换
     *
     * @param opengid the opengid
     * @return the generic response
     */
    public GenericResponse<String> opengidToChatid(String opengid) {
        return workWeChatApiClient.post(WeComEndpoint.OPENGID_TO_CHATID, Collections.singletonMap("opengid", opengid), new ParameterizedTypeReference<GenericResponse<String>>() {
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
        return workWeChatApiClient.post(WeComEndpoint.GROUP_CHAT_ADD_JOIN_WAY, body, new ParameterizedTypeReference<GenericResponse<String>>() {
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
        return workWeChatApiClient.post(WeComEndpoint.GROUP_CHAT_GET_JOIN_WAY, Collections.singletonMap("config_id", configId),
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
        return workWeChatApiClient.post(WeComEndpoint.GROUP_CHAT_UPDATE_JOIN_WAY, body,
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
        return workWeChatApiClient.post(WeComEndpoint.GROUP_CHAT_DEL_JOIN_WAY, Collections.singletonMap("config_id", configId), WeComResponse.class);
    }
}
