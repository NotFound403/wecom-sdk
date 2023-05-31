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
import cn.felord.domain.externalcontact.GroupMsgListRequest;
import cn.felord.domain.externalcontact.GroupMsgListResponse;
import cn.felord.domain.externalcontact.GroupMsgSendResultRequest;
import cn.felord.domain.externalcontact.GroupMsgSendResultResponse;
import cn.felord.domain.externalcontact.GroupMsgTaskRequest;
import cn.felord.domain.externalcontact.GroupMsgTaskResponse;
import cn.felord.domain.externalcontact.MsgTemplateRequest;
import cn.felord.domain.externalcontact.MsgTemplateResponse;
import cn.felord.domain.externalcontact.WelcomeCodeRequest;
import cn.felord.domain.externalcontact.WelcomeTemplateAddRequest;
import cn.felord.domain.externalcontact.WelcomeTemplateEditRequest;
import cn.felord.domain.externalcontact.WelcomeTemplateResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 企业群发
 *
 * @author dax
 * @since 2021 /8/19 14:45
 */
public class GroupMessageApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Group message api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    GroupMessageApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建企业群发
     * <p>
     * 当前创建企业群发是没有办法指定群聊的，服务人员接收到群发消息推送时，是下发给所有的客户
     *
     * @param request the request
     * @return the moment list
     */
    public MsgTemplateResponse addMsgTemplate(MsgTemplateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_ADD, request, MsgTemplateResponse.class);
    }

    /**
     * 提醒成员群发
     * <p>
     * 企业和第三方应用可调用此接口，重新触发群发通知，提醒成员完成群发任务，24小时内每个群发最多触发三次提醒。
     *
     * @param msgId the msg id
     * @return the msg template response
     */
    public WeComResponse remindGroupmsgSend(String msgId) {
        return workWeChatApiClient.post(WeComEndpoint.REMIND_GROUPMSG_SEND, Collections.singletonMap("msgid", msgId), WeComResponse.class);
    }

    /**
     * 停止企业群发
     *
     * @param msgId the msg id
     * @return the we com response
     */
    public WeComResponse cancelGroupmsgSend(String msgId) {
        return workWeChatApiClient.post(WeComEndpoint.CANCEL_GROUPMSG_SEND, Collections.singletonMap("msgid", msgId), WeComResponse.class);
    }

    /**
     * 获取群发记录列表
     * <p>
     *
     * @param request the request
     * @return the groupmsg list v 2
     */
    public GroupMsgListResponse getGroupMsgListV2(GroupMsgListRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_LIST_V2, request, GroupMsgListResponse.class);
    }

    /**
     * 获取群发成员发送任务列表
     *
     * @param request the request
     * @return the group msg task
     */
    public GroupMsgTaskResponse getGroupMsgTask(GroupMsgTaskRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_TASK, request, GroupMsgTaskResponse.class);
    }

    /**
     * 获取企业群发成员执行结果
     *
     * @param request the request
     * @return the group msg send result
     */
    public GroupMsgSendResultResponse getGroupMsgSendResult(GroupMsgSendResultRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_SEND_RESULT, request, GroupMsgSendResultResponse.class);
    }

    /**
     * 发送新客户欢迎语
     *
     * @param request the request
     * @return group msg send result response
     */
    public WeComResponse sendWelcomeGroupMsg(WelcomeCodeRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_SEND_WELCOME, request, WeComResponse.class);
    }

    /**
     * 添加入群欢迎语素材
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> addWelcomeTemplate(WelcomeTemplateAddRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_ADD, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 编辑入群欢迎语素材
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse editWelcomeTemplate(WelcomeTemplateEditRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_EDIT, request, WeComResponse.class);
    }

    /**
     * 获取入群欢迎语素材
     *
     * @param templateId the template id
     * @return the welcome template
     */
    public WelcomeTemplateResponse getWelcomeTemplate(String templateId) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_GET, Collections.singletonMap("template_id", templateId), WelcomeTemplateResponse.class);
    }

    /**
     * 删除入群欢迎语素材
     *
     * @param templateId the template id
     * @return the welcome template response
     */
    public WeComResponse delWelcomeTemplate(String templateId) {
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_DEL, Collections.singletonMap("template_id", templateId), WeComResponse.class);
    }

    /**
     * 删除入群欢迎语素材（仅适用于旧的第三方多应用套件）
     *
     * @param templateId the template id
     * @param agentId    the agent id
     * @return the we com response
     */
    public WeComResponse delWelcomeTemplate(String templateId, String agentId) {
        Map<String, String> body = new HashMap<>(2);
        body.put("template_id", templateId);
        body.put("agentid", agentId);
        return workWeChatApiClient.post(WeComEndpoint.GROUP_MSG_WELCOME_TEMPLATE_DEL, body, WeComResponse.class);
    }
}