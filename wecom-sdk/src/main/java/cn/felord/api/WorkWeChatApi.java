/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.RetrofitFactory;
import cn.felord.WeComTokenCacheable;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 企业微信API
 *
 * @author felord.cn
 */
public final class WorkWeChatApi {
    private final WeComTokenCacheable weComTokenCacheable;
    private final HttpLoggingInterceptor.Level level;
    private final ConnectionPool connectionPool;

    /**
     * Instantiates a new Work we chat api.
     *
     * @param weComTokenCacheable the we com token cacheable
     */
    public WorkWeChatApi(WeComTokenCacheable weComTokenCacheable) {
        this(weComTokenCacheable, new ConnectionPool());
    }

    /**
     * 推荐生产使用
     *
     * @param weComTokenCacheable the we com token cacheable
     * @param connectionPool      the connection pool
     */
    public WorkWeChatApi(WeComTokenCacheable weComTokenCacheable, ConnectionPool connectionPool) {
        this(weComTokenCacheable, connectionPool, HttpLoggingInterceptor.Level.NONE);
    }

    /**
     * Instantiates a new Work we chat api.
     *
     * @param weComTokenCacheable the we com token cacheable
     * @param level               the level
     */
    public WorkWeChatApi(WeComTokenCacheable weComTokenCacheable, HttpLoggingInterceptor.Level level) {
        this(weComTokenCacheable, new ConnectionPool(), level);
    }

    /**
     * 开发使用，输出log
     *
     * @param weComTokenCacheable the we com token cacheable
     * @param connectionPool      the connection pool
     * @param level               the level
     */
    public WorkWeChatApi(WeComTokenCacheable weComTokenCacheable, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        this.weComTokenCacheable = weComTokenCacheable;
        this.connectionPool = connectionPool;
        this.level = level;
    }

    /**
     * 获取企业微信API域名IP段
     *
     * @param agentDetails the agent details
     * @return the domain api
     */
    public DomainApi domainApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(DomainApi.class);
    }

    /**
     * 通讯录管理
     *
     * @param agentDetails the agent details
     * @return the Address book Manager
     */
    public ContactBookManager contactBookManager(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new ContactBookManager(WorkWeChatApiClient.init(tokenApi, connectionPool, level));
    }

    /**
     * 客户联系
     *
     * @param agentDetails the agent details
     * @return the external contact manager
     */
    public ExternalContactManager externalContactManager(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new ExternalContactManager(WorkWeChatApiClient.init(tokenApi, connectionPool, level));
    }

    /**
     * 微信客服
     *
     * @param agentDetails the agent details
     * @return the call center manager
     */
    public CallCenterManager callCenterManager(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new CallCenterManager(WorkWeChatApiClient.init(tokenApi, connectionPool, level));
    }

    /**
     * 身份验证
     *
     * @param agentDetails the agent details
     * @return the auth api
     */
    public AuthApi authApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(AuthApi.class);
    }

    /**
     * 企微应用API
     *
     * @param agentDetails the agent details
     * @return the agent api
     */
    public AgentApi agentApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new AgentApi(WorkWeChatApiClient.init(tokenApi, connectionPool, level));
    }

    /**
     * SDK ticket相关接口
     *
     * @param agentDetails the agent details
     * @return the sdk ticket api
     */
    public SdkTicketApi sdkTicketApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new SdkTicketApi(WorkWeChatApiClient.init(tokenApi, connectionPool, level), weComTokenCacheable);
    }

    /**
     * Webhook相关接口
     *
     * @return the webhook api
     */
    public static WebhookApi webhookApi() {
        return new WebhookApi(RetrofitFactory.RETROFIT_);
    }

    /**
     * 素材接口
     *
     * @param agentDetails the agent details
     * @return the media api
     */
    public MediaApi mediaApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new MediaApi(WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit());
    }

    /**
     * 日历相关接口
     *
     * @param agentDetails the agent details
     * @return the calendar api
     */
    public CalendarApi calendarApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(CalendarApi.class);
    }

    /**
     * 日程相关接口
     *
     * @param agentDetails the agent details
     * @return the schedule api
     */
    public ScheduleApi scheduleApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(ScheduleApi.class);
    }


    /**
     * 文档API
     *
     * @param agentDetails the agent details
     * @return the wedoc api
     */
    public WedocApi wedocApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new WedocApi(WorkWeChatApiClient.init(tokenApi, connectionPool, level));
    }

    /**
     * 微盘API
     *
     * @param agentDetails the agent details
     * @return the we drive api
     */
    public WeDriveApi weDriveApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new WeDriveApi(WorkWeChatApiClient.init(tokenApi, connectionPool, level));
    }

    /**
     * 审批API
     *
     * @param agentDetails the agent details
     * @return the approval api
     */
    public ApprovalApi approvalApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(ApprovalApi.class);
    }

    /**
     * 紧急通知API（限医疗行业）
     *
     * @param agentDetails the agent details
     * @return the urgent call api
     */
    public UrgentCallApi urgentCallApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(UrgentCallApi.class);
    }
}
