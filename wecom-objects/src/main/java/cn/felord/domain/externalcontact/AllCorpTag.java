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

import java.util.Collections;
import java.util.Set;

/**
 * The type All corp tag.
 *
 * @author dax
 * @since 2021 /8/13 18:39
 */
@Getter
public class AllCorpTag implements CorpTagIterator {
    private final Set<String> groupId;
    private final Set<String> tagId;

    /**
     * Instantiates a new All corp tag.
     */
    public AllCorpTag() {
        this.groupId = Collections.emptySet();
        this.tagId = Collections.emptySet();
    }

    /**
     * Query all corp tag.
     *
     * @return the all corp tag
     */
    public static AllCorpTag query() {
        return new AllCorpTag();
    }
}
