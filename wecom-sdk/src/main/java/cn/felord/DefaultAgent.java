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

package cn.felord;

import cn.felord.enumeration.NativeAgent;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type Agent.
 *
 * @author n1
 * @since 2021 /6/17 14:21
 */
@AllArgsConstructor
@Getter
public class DefaultAgent implements AgentDetails {

    private final String corpId;

    private final String secret;

    private final String agentId;


    /**
     * 获取内置基础应用
     *
     * @param corpId the corp id
     * @param secret the secret
     * @param agent  the agent
     * @return the agent details
     */
    public static AgentDetails nativeAgent(String corpId,String secret,NativeAgent agent){
        return new DefaultAgent(corpId,secret, agent.getAgentId());
    }
}
