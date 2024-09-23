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

package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComTokenCacheable;
import cn.felord.retrofit.AccessTokenApi;
import cn.felord.retrofit.ssl.SSLManager;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 企业支付
 *
 * @author dax
 * @since 2024/6/28
 */
public class PayApi {
    private final WeComTokenCacheable weComTokenCacheable;
    private final ConnectionPool connectionPool;
    private final HttpLoggingInterceptor.Level level;

    /**
     * Instantiates a new Pay api.
     *
     * @param weComTokenCacheable the we com token cacheable
     * @param connectionPool      the connection pool
     * @param level               the level
     */
    PayApi(WeComTokenCacheable weComTokenCacheable, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        this.weComTokenCacheable = weComTokenCacheable;
        this.connectionPool = connectionPool;
        this.level = level;
    }

    /**
     * 企业红包和向员工付款
     *
     * @param paySecret      微信支付密钥
     * @param payAgentSecret 企业微信支付应用secret（参见企业微信管理端支付应用页面）
     * @param sslManager     微信支付SSL，要对应paySecret
     * @return the corpay api
     */
    public InternalCorPayApi internal(String paySecret, String payAgentSecret, SSLManager sslManager) {
        return new InternalCorPayApi(paySecret, payAgentSecret, sslManager, connectionPool, level);
    }

    /**
     * 对外收款
     * <p>
     * 对外收款是企业微信提供的面向微信用户使用的收款方式，可以在聊天中、用收款码、在直播间、使用商品图册等多种方式收款。
     *
     * @param agentDetails the agent details
     * @return the external cor pay api
     */
    public ExternalCorPayApi external(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(ExternalCorPayApi.class);
    }

    /**
     * 对外收款账户
     *
     * @param agentDetails the agent details
     * @return the external pay account api
     */
    public ExternalPayAccountApi externalPayAccountApi(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(ExternalPayAccountApi.class);
    }

    /**
     * 小程序接入对外收款
     * <p>
     * 本接口适用于在 由企业微信向微信发出的小程序中使用对外收款账户进行收款。
     * <p>
     * 调用权限说明：
     * <ul>
     *     <li>目前本目录下所有接口仅支持『对外收款』应用调用，即获取access_token时需要使用『对外收款』应用的SECRET</li>
     * </ul>
     * 开发前准备
     * <ol>
     *     <li>在使用本接口前，需要在手机端或企业微信管理后台对外收款中申请收款账户；</li>
     *     <li>在手机端「对外收款-小程序」中绑定需要接入的小程序和对外收款账户；</li>
     *     <li>在企业微信管理后台「应用管理 - 对外收款 - API」中设置企业可信IP，仅企业可信IP可调用本目录相关接口；</li>
     *     <li>在企业微信管理后台「应用管理 - 对外收款」中设置接收事件服务器，用于接收支付和退款相关的回调通知。</li>
     * </ol>
     *
     * @param agentDetails the agent details
     * @return the mini app pay
     */
    public MiniAppPayApi miniAppPay(AgentDetails agentDetails) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, agentDetails);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(MiniAppPayApi.class);
    }
}
