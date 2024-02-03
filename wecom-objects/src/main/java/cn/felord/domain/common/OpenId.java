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

package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The type Open id.
 *
 * @author dax
 * @since 2023 /5/24 15:55
 */
@ToString
@Getter
public class OpenId {
    private final String openid;

    /**
     * Instantiates a new Open id.
     *
     * @param openid the openid
     */
    @JsonCreator
    public OpenId(@JsonProperty("openid") String openid) {
        this.openid = openid;
    }

    /**
     * Of openid.
     *
     * @param openid the openid
     * @return the open id
     */
    public static OpenId of(@NonNull String openid) {
        return new OpenId(openid);
    }
}
