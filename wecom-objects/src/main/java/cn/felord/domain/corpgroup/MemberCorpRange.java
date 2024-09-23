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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Member corp range.
 *
 * @author dax
 * @since 2024/10/13
 */
@ToString
@Getter
public class MemberCorpRange {
    private final List<String> corpids;
    private final List<String> groupids;


    /**
     * Instantiates a new Member corp range.
     *
     * @param corpids  the corpids
     * @param groupids the groupids
     */
    @JsonCreator
    MemberCorpRange(@JsonProperty("corpids") List<String> corpids,
                    @JsonProperty("groupids") List<String> groupids) {
        this.corpids = corpids;
        this.groupids = groupids;
    }

    public static OwnerCorpRange both(List<String> corpids, List<String> groupids) {
        return new OwnerCorpRange(corpids, groupids);
    }

    /**
     * User ids owner corp range.
     *
     * @param corpids the corpids
     * @return the owner corp range
     */
    public static OwnerCorpRange corpIds(List<String> corpids) {
        return new OwnerCorpRange(corpids, null);
    }

    /**
     * groupids owner corp range.
     *
     * @param groupids the groupids
     * @return the owner corp range
     */
    public static OwnerCorpRange groupIds(List<String> groupids) {
        return new OwnerCorpRange(null, groupids);
    }
}
