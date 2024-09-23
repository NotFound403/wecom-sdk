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

package cn.felord.domain.callcenter.knowledge;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Intents request.
 *
 * @author dax
 * @since 2024/10/5
 */
@ToString
@Getter
public class IntentsRequest {
    private String cursor;
    private String intentId;
    private String groupId;
    private Integer limit;

    /**
     * Cursor intents request.
     *
     * @param cursor the cursor
     * @return the intents request
     */
    public IntentsRequest cursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Intent id intents request.
     *
     * @param intentId the intent id
     * @return the intents request
     */
    public IntentsRequest intentId(String intentId) {
        this.intentId = intentId;
        return this;
    }

    /**
     * Group id intents request.
     *
     * @param groupId the group id
     * @return the intents request
     */
    public IntentsRequest groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    /**
     * Limit intents request.
     *
     * @param limit the limit
     * @return the intents request
     */
    public IntentsRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }
}
