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
 * The type Chain corp detail request.
 *
 * @author dax
 * @since 2024/10/12
 */
@ToString
@Getter
public class ChainCorpDetailRequest {
    private final String chainId;
    private final String corpid;
    private final String pendingCorpid;

    /**
     * Instantiates a new Chain corp detail request.
     *
     * @param chainId       the chain id
     * @param corpid        the corpid
     * @param pendingCorpid the pending corpid
     */
    ChainCorpDetailRequest(String chainId, String corpid, String pendingCorpid) {
        this.chainId = chainId;
        this.corpid = corpid;
        this.pendingCorpid = pendingCorpid;
    }

    /**
     * With corp id chain corp detail request.
     *
     * @param chainId the chain id
     * @param corpid  the corpid
     * @return the chain corp detail request
     */
    public static ChainCorpDetailRequest withCorpId(String chainId, String corpid) {
        return new ChainCorpDetailRequest(chainId, corpid, null);
    }

    /**
     * With pending corp id chain corp detail request.
     *
     * @param chainId       the chain id
     * @param pendingCorpid the pending corpid
     * @return the chain corp detail request
     */
    public static ChainCorpDetailRequest withPendingCorpId(String chainId, String pendingCorpid) {
        return new ChainCorpDetailRequest(chainId, null, pendingCorpid);
    }
}
