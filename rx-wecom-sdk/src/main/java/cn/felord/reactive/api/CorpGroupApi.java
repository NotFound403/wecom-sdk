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

import cn.felord.DefaultAgent;
import cn.felord.DownStreamDetails;
import cn.felord.WeComTokenCacheable;
import cn.felord.retrofit.AccessTokenApi;
import cn.felord.retrofit.DownStreamTokenApi;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 企业互联与上下游
 *
 * @author dax
 * @since 2024/10/12
 */
public class CorpGroupApi {
    private final WeComTokenCacheable weComTokenCacheable;
    private final ConnectionPool connectionPool;
    private final HttpLoggingInterceptor.Level level;

    /**
     * Instantiates a new Corp group api.
     *
     * @param weComTokenCacheable the we com token cacheable
     * @param connectionPool      the connection pool
     * @param level               the level
     */
    CorpGroupApi(WeComTokenCacheable weComTokenCacheable,
                 ConnectionPool connectionPool,
                 HttpLoggingInterceptor.Level level) {
        this.weComTokenCacheable = weComTokenCacheable;
        this.connectionPool = connectionPool;
        this.level = level;
    }


    /**
     * 上游API
     * <p>
     * 上下游系统应用或上游应用可调用，具体看接口注释
     *
     * @param upStreamAgent the up stream agent
     * @return the up stream api
     */
    public UpStreamApi upStreamApi(DefaultAgent upStreamAgent) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, upStreamAgent);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(UpStreamApi.class);
    }

    /**
     * 下游API
     *
     * @param downStreamAgent the down stream agent
     * @return the down stream api
     */
    public DownStreamApi downStreamApi(DownStreamDetails downStreamAgent) {
        DownStreamTokenApi tokenApi = new DownStreamTokenApi(weComTokenCacheable, downStreamAgent);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(DownStreamApi.class);
    }

    /**
     * 上下游规则
     * <p>
     * 仅上下游应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param corpChainAgent the corp chain agent
     * @return the chain rule api
     */
    public ChainRuleApi chainRuleApi(DefaultAgent corpChainAgent) {
        AccessTokenApi tokenApi = new AccessTokenApi(weComTokenCacheable, corpChainAgent);
        return WorkWeChatApiClient.init(tokenApi, connectionPool, level)
                .retrofit()
                .create(ChainRuleApi.class);
    }
}
