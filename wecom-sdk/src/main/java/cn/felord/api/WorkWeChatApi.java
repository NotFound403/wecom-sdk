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

import cn.felord.AgentDetails;
import cn.felord.WeComTokenCacheable;

/**
 * 企业微信API
 *
 * @author felord.cn
 */
public final class WorkWeChatApi {

    private final WeComTokenCacheable weComTokenCacheable;


    /**
     * Instantiates a new Work we chat api.
     *
     * @param weComTokenCacheable the we com token cacheable
     */
    public WorkWeChatApi(WeComTokenCacheable weComTokenCacheable) {
        this.weComTokenCacheable = weComTokenCacheable;
    }


    /**
     * 获取企业微信API域名IP段
     *
     * @param agentDetails the agent details
     * @return the domain api
     */
    public DomainApi domainApi(AgentDetails agentDetails) {
        return new DomainApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 通讯录管理
     *
     * @param agentDetails the agent details
     * @return the Address book Manager
     */
    public ContactBookManager contactBookManager(AgentDetails agentDetails) {
        return new ContactBookManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 客户联系
     *
     * @param agentDetails the agent details
     * @return the external contact manager
     */
    public ExternalContactManager externalContactManager(AgentDetails agentDetails) {
        return new ExternalContactManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 微信客服
     *
     * @param agentDetails the agent details
     * @return the call center manager
     */
    public CallCenterManager callCenterManager(AgentDetails agentDetails) {
        return new CallCenterManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 身份验证
     *
     * @param agentDetails the agent details
     * @return the auth api
     */
    public AuthApi authApi(AgentDetails agentDetails) {
        return new AuthApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 应用管理
     *
     * @param agentDetails the agent details
     * @return the agent manager
     */
    public AgentManager agentManager(AgentDetails agentDetails) {
        return new AgentManager(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * SDK ticket相关接口
     *
     * @param agentDetails the agent details
     * @return the sdk ticket api
     */
    public SdkTicketApi sdkTicketApi(AgentDetails agentDetails) {
        return new SdkTicketApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)), weComTokenCacheable);
    }

    /**
     * Webhook相关接口
     *
     * @return the webhook api
     */
    public static WebhookApi webhookApi() {
        return new WebhookApi();
    }

    /**
     * 素材接口
     *
     * @param agentDetails the agent details
     * @return the media api
     */
    public MediaApi mediaApi(AgentDetails agentDetails) {
        return new MediaApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 日历相关接口
     *
     * @param agentDetails the agent details
     * @return the calendar api
     */
    public CalendarApi calendarApi(AgentDetails agentDetails) {
        return new CalendarApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 日程相关接口
     *
     * @param agentDetails the agent details
     * @return the schedule api
     */
    public ScheduleApi scheduleApi(AgentDetails agentDetails) {
        return new ScheduleApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 消息推送
     *
     * @param agentDetails the agent details
     * @return the message api
     */
    public AgentMessageApi agentMessageApi(AgentDetails agentDetails) {
        return new AgentMessageApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 文档API
     *
     * @param agentDetails the agent details
     * @return the wedoc api
     */
    public WedocApi wedocApi(AgentDetails agentDetails) {
        return new WedocApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 微盘API
     *
     * @param agentDetails the agent details
     * @return the we drive api
     */
    public WeDriveApi weDriveApi(AgentDetails agentDetails) {
        return new WeDriveApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }

    /**
     * 审批API
     *
     * @param agentDetails the agent details
     * @return the approval api
     */
    public ApprovalApi approvalApi(AgentDetails agentDetails) {
        return new ApprovalApi(new WorkWeChatApiClient(new AccessTokenApi(weComTokenCacheable, agentDetails)));
    }
}
