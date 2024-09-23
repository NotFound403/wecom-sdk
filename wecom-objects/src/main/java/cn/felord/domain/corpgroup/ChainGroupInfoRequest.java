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
 * The type Chain group info request.
 *
 * @author dax
 * @since 2024/10/12
 */
@ToString
@Getter
public class ChainGroupInfoRequest {
    private final String chainId;
    private String cursor;
    private Integer groupid;
    private Integer limit;
    private Boolean needPending;

    /**
     * Instantiates a new Chain group info request.
     *
     * @param chainId the chain id
     */
    public ChainGroupInfoRequest(String chainId) {
        this.chainId = chainId;
    }

    /**
     * Cursor chain group info request.
     *
     * @param cursor the cursor
     * @return the chain group info request
     */
    public ChainGroupInfoRequest cursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Groupid chain group info request.
     *
     * @param groupid the groupid
     * @return the chain group info request
     */
    public ChainGroupInfoRequest groupid(Integer groupid) {
        this.groupid = groupid;
        return this;
    }

    /**
     * Limit chain group info request.
     *
     * @param limit the limit
     * @return the chain group info request
     */
    public ChainGroupInfoRequest limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Need pending chain group info request.
     *
     * @param needPending the need pending
     * @return the chain group info request
     */
    public ChainGroupInfoRequest needPending(boolean needPending) {
        this.needPending = needPending;
        return this;
    }
}
