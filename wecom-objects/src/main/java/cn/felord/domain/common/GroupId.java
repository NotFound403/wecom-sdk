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

package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Group id.
 *
 * @author dax
 * @since 2024 /10/5
 */
@ToString
@Getter
public class GroupId {
    private final String groupId;

    /**
     * Instantiates a new Group id.
     *
     * @param groupId the group id
     */
    @JsonCreator
    public GroupId(@JsonProperty("group_id") String groupId) {
        this.groupId = groupId;
    }

    /**
     * Of group id.
     *
     * @param groupId the group id
     * @return the group id
     */
    public static GroupId of(String groupId) {
        return new GroupId(groupId);
    }
}
