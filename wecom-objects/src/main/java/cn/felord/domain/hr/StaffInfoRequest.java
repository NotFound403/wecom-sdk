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

package cn.felord.domain.hr;

import lombok.Getter;

import java.util.List;

/**
 * The type Staff info request.
 *
 * @author dax
 * @since 2024/8/3 11:42
 */
@Getter
public class StaffInfoRequest {
    private final String userid;
    private Boolean getAll;
    private List<FieldId> fieldids;

    /**
     * Instantiates a new Staff info request.
     *
     * @param userid the userid
     */
    public StaffInfoRequest(String userid) {
        this.userid = userid;
        this.getAll = true;
    }

    /**
     * Instantiates a new Staff info request.
     *
     * @param userid   the userid
     * @param fieldids the fieldids
     */
    public StaffInfoRequest(String userid, List<FieldId> fieldids) {
        this.userid = userid;
        this.fieldids = fieldids;
    }
}
