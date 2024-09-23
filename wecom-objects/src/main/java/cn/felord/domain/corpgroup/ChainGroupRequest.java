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

package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Chain group request.
 *
 * @author dax
 * @since 2024/10/12
 */
@ToString
@Getter
public class ChainGroupRequest {
    private final String chainId;
    private Integer groupid;


    /**
     * Instantiates a new Chain group request.
     *
     * @param chainId the chain id
     */
    public ChainGroupRequest(String chainId) {
        this.chainId = chainId;
    }

    /**
     * Instantiates a new Chain group request.
     *
     * @param chainId the chain id
     * @param groupid the groupid
     */
    public ChainGroupRequest(String chainId, int groupid) {
        this.chainId = chainId;
        this.groupid = groupid;
    }
}
