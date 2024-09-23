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
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * 下游应用
 *
 * @author dax
 * @since 2024/10/12
 */
@ToString
@Getter
public class DownStreamDetails implements AgentDetails {

    /**
     * 上级/上游企业应用，要和下游应用有授权关系
     */
    private final DefaultAgent upStreamDetails;
    /**
     * 已授权的下级/下游企业corpid
     */
    @NonNull
    private final String corpId;
    /**
     * 已授权的下级/下游企业应用ID
     */
    @NonNull
    private final String agentId;
    /**
     * 填0则为企业互联/局校互联，填1则表示上下游企业
     */
    private final CorpGroupType businessType;

    /**
     * Instantiates a new Down stream details.
     *
     * @param upStreamDetails the up stream details
     * @param corpId          the corp id
     * @param agentId         the agent id
     */
    public DownStreamDetails(@NonNull DefaultAgent upStreamDetails, @NonNull String corpId, @NonNull String agentId) {
        this(upStreamDetails, corpId, agentId, null);
    }


    /**
     * Instantiates a new Down stream details.
     *
     * @param upStreamDetails the up stream details
     * @param corpId          the corp id
     * @param agentId         the agent id
     * @param businessType    the business type
     */
    public DownStreamDetails(@NonNull DefaultAgent upStreamDetails,
                             @NonNull String corpId,
                             @NonNull String agentId,
                             CorpGroupType businessType) {
        this.upStreamDetails = upStreamDetails;
        this.corpId = corpId;
        this.agentId = agentId;
        this.businessType = businessType;
    }


    /**
     * Instantiates a new Down stream details.
     *
     * @param corpId       the corp id
     * @param agentId      the agent id
     * @param businessType the business type
     */
    DownStreamDetails(@NonNull String corpId, @NonNull String agentId, CorpGroupType businessType) {
        this.upStreamDetails = null;
        this.corpId = corpId;
        this.agentId = agentId;
        this.businessType = businessType;
    }

    /**
     * To request down stream details.
     *
     * @return the down stream details
     */
    public DownStreamDetails toRequest() {
        return new DownStreamDetails(this.corpId, this.agentId, this.businessType);
    }

    @Override
    public String getSecret() {
        return null;
    }
}
