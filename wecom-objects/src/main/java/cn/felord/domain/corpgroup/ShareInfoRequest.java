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
 * The type Share info request.
 *
 * @author dax
 * @since 2024/5/27
 */
@ToString
@Getter
public class ShareInfoRequest {
    /**
     * 上级/上游企业应用agentid
     */
    private final Integer agentid;
    /**
     * 游标
     */
    private String cursor;
    /**
     * 下级/下游企业corpid，若指定该参数则表示拉取该下级/下游企业的应用共享信息
     */
    private String corpid;
    /**
     * 填0则为企业互联/局校互联，填1则表示上下游企业
     */
    private Integer businessType;
    /**
     * 返回的最大记录数，整型，最大值100，
     * 默认情况或者值为0表示下拉取全量数据，建议分页拉取或者通过指定corpid参数拉取。
     */
    private Integer limit;

    /**
     * Instantiates a new Share info request.
     *
     * @param agentid the agentid
     */
    public ShareInfoRequest(Integer agentid) {
        this.agentid = agentid;
    }

    /**
     * Cursor share info request.
     *
     * @param cursor the cursor
     * @return the share info request
     */
    public ShareInfoRequest cursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Corpid share info request.
     *
     * @param corpid the corpid
     * @return the share info request
     */
    public ShareInfoRequest corpid(String corpid) {
        this.corpid = corpid;
        return this;
    }

    /**
     * Business type share info request.
     *
     * @param businessType the business type
     * @return the share info request
     */
    public ShareInfoRequest businessType(Integer businessType) {
        this.businessType = businessType;
        return this;
    }

    /**
     * Limit share info request.
     *
     * @param limit the limit
     * @return the share info request
     */
    public ShareInfoRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }
}
