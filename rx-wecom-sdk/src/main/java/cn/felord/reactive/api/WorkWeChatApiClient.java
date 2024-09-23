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
import cn.felord.retrofit.WorkWechatRetrofitFactory;
import cn.felord.retrofit.TokenApi;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * The type Abstract agent api.
 *
 * @author n1
 * @since 2021 /6/16 19:36
 */
public final class WorkWeChatApiClient {
    private final AgentDetails agentDetails;
    private final Retrofit retrofit;

    /**
     * Instantiates a new Work we chat api client.
     *
     * @param agentDetails the agent details
     * @param retrofit     the retrofit
     */
    WorkWeChatApiClient(AgentDetails agentDetails, Retrofit retrofit) {
        this.agentDetails = agentDetails;
        this.retrofit = retrofit;
    }

    /**
     * Instantiates a new Work we chat api client.
     *
     * @param <T>            the type parameter
     * @param tokenApi       the token api
     * @param connectionPool the connection pool
     * @param level          the level
     * @return the work we chat api client
     */
    public static <T extends TokenApi> WorkWeChatApiClient init(T tokenApi, ConnectionPool connectionPool, HttpLoggingInterceptor.Level level) {
        return new WorkWeChatApiClient(tokenApi.getAgentDetails(), WorkWechatRetrofitFactory.create(tokenApi, connectionPool, level));
    }

    /**
     * Gets agent details.
     *
     * @return the agent details
     */
    AgentDetails agentDetails() {
        return agentDetails;
    }

    /**
     * Retrofit retrofit.
     *
     * @return the retrofit
     */
    Retrofit retrofit() {
        return retrofit;
    }
}
