/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.reactive.api;

import cn.felord.AgentDetails;
import cn.felord.WeComTokenCacheable;
import cn.felord.retrofit.AccessTokenApi;
import cn.felord.retrofit.WorkWechatRetrofitFactory;
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
     * 安全管理
     *
     * @param agentDetails the agent details
     * @return the security api
     * @since 1.2.2
     */
    public SecurityApi securityApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(SecurityApi.class);
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
     * 企业支付
     *
     * @return the pay api
     */
    public PayApi payApi() {
        return new PayApi(weComTokenCacheable, connectionPool, level);
    }

    /**
     * 会话内容存档
     *
     * @param agentDetails the agent details
     * @return the msg audit api
     */
    public MsgAuditApi msgAuditApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(MsgAuditApi.class);
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
     * 企业互联与上下游
     *
     * @return the corp group api
     */
    public CorpGroupApi corpGroupApi() {
        return new CorpGroupApi(weComTokenCacheable, connectionPool, level);
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
     * Js SDK 相关接口
     *
     * @param agentDetails the agent details
     * @return the sdk ticket api
     */
    public JsSdkApi jsSdkApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return new JsSdkApi(WorkWeChatApiClient.init(tokenApi, connectionPool, level), weComTokenCacheable);
    }

    /**
     * Webhook相关接口
     *
     * @return the webhook api
     */
    public static WebhookApi webhookApi() {
        return new WebhookApi(WorkWechatRetrofitFactory.RETROFIT_);
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
     * 电子发票
     *
     * @param agentDetails the agent details
     * @return the invoice api
     */
    public InvoiceApi invoiceApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(InvoiceApi.class);
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
     * 直播API
     *
     * @param agentDetails the agentDetails
     * @return living api
     * @since 1.2.4
     */
    public LivingApi livingApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(LivingApi.class);
    }

    /**
     * 公费电话API
     *
     * @param agentDetails the agent details
     * @return the approval api
     */
    public DialApi dialApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(DialApi.class);
    }

    /**
     * 打卡API
     *
     * @param agentDetails the agent details
     * @return the checkin api
     */
    public CheckinApi checkinApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(CheckinApi.class);
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
     * 汇报API
     *
     * @param agentDetails the agent details
     * @return the journal api
     */
    public JournalApi journalApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(JournalApi.class);
    }

    /**
     * 人事助手API
     *
     * @param agentDetails the agent details
     * @return the staff manager api
     */
    public StaffManagerApi staffManagerApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(StaffManagerApi.class);
    }

    /**
     * 会议室API
     *
     * @param agentDetails the agent details
     * @return the meeting room api
     */
    public MeetingRoomApi meetingRoomApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(MeetingRoomApi.class);
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
