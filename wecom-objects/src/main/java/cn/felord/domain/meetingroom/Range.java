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

package cn.felord.domain.meetingroom;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Range.
 *
 * @author dax
 * @since 2021 /7/12 19:23
 */
@ToString
@Getter
public class Range {
    /**
     * 会议室使用范围的部门id列表，（仅会议室系统应用查询时返回）
     */
    private final List<Integer> departmentList;
    /**
     * 会议室使用范围的userid列表（仅会议室系统应用查询时返回）
     */
    private final List<String> userList;

    /**
     * Instantiates a new Range.
     *
     * @param departmentList the department list
     * @param userList       the user list
     */
    @JsonCreator
    Range(@JsonProperty("department_list") List<Integer> departmentList,
          @JsonProperty("user_list") List<String> userList) {
        this.departmentList = departmentList;
        this.userList = userList;
    }
}
