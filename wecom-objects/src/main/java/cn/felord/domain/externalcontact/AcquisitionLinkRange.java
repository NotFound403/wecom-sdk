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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

/**
 * The type Acquisition link range.
 *
 * @author dax
 * @since 2024/5/30
 */
@ToString
@Getter
public class AcquisitionLinkRange {
    private final Set<String> userList;
    private final List<Long> departmentList;

    /**
     * Instantiates a new Acquisition link range.
     *
     * @param userList       the user list
     * @param departmentList the department list
     */
    @JsonCreator
    AcquisitionLinkRange(@JsonProperty("user_list") Set<String> userList,
                         @JsonProperty("department_list") List<Long> departmentList) {
        this.userList = userList;
        this.departmentList = departmentList;
    }

}
