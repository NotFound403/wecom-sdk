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

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The type Approval sp no.
 *
 * @author dax
 * @since 2024/6/9 15:13
 */
@ToString
@Getter
public class ApprovalSpNo {
    private final String spNo;

    /**
     * Instantiates a new Approval sp no.
     *
     * @param spNo the spNo
     */
    @JsonCreator
    public ApprovalSpNo(@JsonProperty("sp_no") String spNo) {
        this.spNo = spNo;
    }

    /**
     * From approval sp no.
     *
     * @param spNo the sp no
     * @return the approval sp no
     */
    public static ApprovalSpNo from(@NonNull String spNo) {
        return new ApprovalSpNo(spNo);
    }
}
