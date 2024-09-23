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
 * The type Owner corp range.
 *
 * @author dax
 * @since 2024/10/13
 */
@ToString
@Getter
public class OwnerCorpRange {
    private final List<String> userids;
    private final List<String> departmentids;

    /**
     * Instantiates a new Owner corp range.
     *
     * @param userids       the userids
     * @param departmentids the departmentids
     */
    @JsonCreator
    OwnerCorpRange(@JsonProperty("userids") List<String> userids,
                   @JsonProperty("departmentids") List<String> departmentids) {
        this.userids = userids;
        this.departmentids = departmentids;
    }

    /**
     * Both owner corp range.
     *
     * @param userids       the userids
     * @param departmentids the departmentids
     * @return the owner corp range
     */
    public static OwnerCorpRange both(List<String> userids, List<String> departmentids) {
        return new OwnerCorpRange(userids, departmentids);
    }

    /**
     * User ids owner corp range.
     *
     * @param userids the userids
     * @return the owner corp range
     */
    public static OwnerCorpRange userIds(List<String> userids) {
        return new OwnerCorpRange(userids, null);
    }

    /**
     * Departmentids owner corp range.
     *
     * @param departmentids the departmentids
     * @return the owner corp range
     */
    public static OwnerCorpRange departmentIds(List<String> departmentids) {
        return new OwnerCorpRange(null, departmentids);
    }
}
