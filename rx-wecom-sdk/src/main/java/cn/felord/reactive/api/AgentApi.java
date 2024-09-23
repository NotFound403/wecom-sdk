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

/**
 * 企微应用API
 *
 * @author dax
 * @since 2024/6/9 16:33
 */
public class AgentApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Contact book manager.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    AgentApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 应用管理
     *
     * @return the agent manager
     */
    public AgentManagerApi agentManager() {
        return new AgentManagerApi(workWeChatApiClient.retrofit(), workWeChatApiClient.agentDetails());
    }

    /**
     * 消息推送
     *
     * @return the message api
     */
    public AgentMessageApi agentMessageApi() {
        return new AgentMessageApi(workWeChatApiClient.retrofit(), workWeChatApiClient.agentDetails());
    }
}
