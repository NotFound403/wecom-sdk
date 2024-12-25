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

package cn.felord.domain.externalcontact;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;

/**
 * The type All corp tag.
 *
 * @author dax
 * @since 2021 /8/13 18:39
 */
@ToString
@Getter
public class CorpTagRequest {
    private final Set<String> groupId;
    private final Set<String> tagId;

    /**
     * Instantiates a new All corp tag.
     *
     * @param groupId the group id
     * @param tagId   the tag id
     */
    CorpTagRequest(Set<String> groupId, Set<String> tagId) {
        this.groupId = groupId;
        this.tagId = tagId;
    }

    /**
     * Query all corp tag.
     *
     * @return the all corp tag
     */
    public static CorpTagRequest all() {
        return new CorpTagRequest(Collections.emptySet(), Collections.emptySet());
    }

    /**
     * Group all corp tag.
     *
     * @param groupId the group id
     * @return the all corp tag
     */
    public static CorpTagRequest group(Set<String> groupId) {
        return new CorpTagRequest(groupId, Collections.emptySet());
    }

    /**
     * Tag all corp tag.
     *
     * @param tagId the tag id
     * @return the all corp tag
     */
    public static CorpTagRequest tag(Set<String> tagId) {
        return new CorpTagRequest(Collections.emptySet(), tagId);
    }
}
