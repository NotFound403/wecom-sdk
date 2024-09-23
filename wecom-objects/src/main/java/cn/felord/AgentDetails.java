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

package cn.felord;

import cn.felord.enumeration.CorpGroupType;

/**
 * The interface Agent details.
 *
 * @author n1
 * @since 2021 /6/17 10:15
 */
public interface AgentDetails {
    /**
     * 企业ID
     *
     * @return the corpId
     */
    String getCorpId();

    /**
     * 应用秘钥或者管理秘钥
     *
     * @return the corp secret
     */
    String getSecret();

    /**
     * 应用ID，内置应用需要虚拟化一个ID
     *
     * @return the agent id
     */
    String getAgentId();

    /**
     * 互联类型（上下游专用）
     *
     * @return business type
     */
    CorpGroupType getBusinessType();

}
