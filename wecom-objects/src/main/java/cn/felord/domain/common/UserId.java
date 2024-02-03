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
 * The type User id.
 *
 * @author dax
 * @since 2023 /5/24 15:55
 */
@ToString
@Getter
public class UserId {
    private final String userid;

    /**
     * Instantiates a new User id.
     *
     * @param userid the userid
     */
    @JsonCreator
    public UserId(@JsonProperty("userid") String userid) {
        this.userid = userid;
    }

    /**
     * Of userid.
     *
     * @param userid the userid
     * @return the user id
     */
    public static UserId of(@NonNull String userid) {
        return new UserId(userid);
    }
}
