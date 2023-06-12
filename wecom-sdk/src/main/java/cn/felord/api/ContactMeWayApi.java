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
import cn.felord.domain.externalcontact.ChatPair;
import cn.felord.domain.externalcontact.ContactListRequest;
import cn.felord.domain.externalcontact.ContactListResponse;
import cn.felord.domain.externalcontact.ContactWayAddResponse;
import cn.felord.domain.externalcontact.ContactWayBody;
import cn.felord.domain.externalcontact.ContactWayBodyDetail;
import cn.felord.domain.externalcontact.MutableContactWay;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;
import java.util.List;

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
        return workWeChatApiClient.get(WeComEndpoint.EXTERNALCONTACT_FOLLOW_USER_LIST, new ParameterizedTypeReference<GenericResponse<List<String>>>() {
        });
    }

    /**
     * 配置客户联系「联系我」方式
     *
     * @param request the request
     * @return the we com response
     */
    public ContactWayAddResponse addContactWay(ContactWayBody request) {
        return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_ADD_CONTACT_WAY, request, ContactWayAddResponse.class);
    }

    /**
     * 获取企业已配置的「联系我」方式
     *
     * @param configId the config id
     * @return the we com response
     */
    public GenericResponse<ContactWayBodyDetail> getContactWay(String configId) {
        return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_GET_CONTACT_WAY,
                Collections.singletonMap("config_id", configId),
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
        return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_LIST_CONTACT_WAY, request, ContactListResponse.class);
    }

    /**
     * 更新企业已配置的「联系我」方式
     *
     * @param contactWay the contact way
     * @return the we com response
     */
    public WeComResponse updateContactWay(MutableContactWay contactWay) {
        return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_UPDATE_CONTACT_WAY, contactWay, WeComResponse.class);
    }

    /**
     * 删除企业已配置的「联系我」方式
     *
     * @param configId the config id
     * @return the we com response
     */
    public WeComResponse delContactWay(String configId) {
        return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_DEL_CONTACT_WAY, Collections.singletonMap("config_id", configId), WeComResponse.class);
    }

    /**
     * 结束临时会话
     *
     * @param userid         the userid
     * @param externalUserid the external userid
     * @return the we com response
     */
    public WeComResponse closeTempChat(String userid, String externalUserid) {
        ChatPair body = new ChatPair(userid, externalUserid);
        return workWeChatApiClient.post(WeComEndpoint.EXTERNALCONTACT_CLOSE_TEMP_CHAT, body, WeComResponse.class);
    }
}
