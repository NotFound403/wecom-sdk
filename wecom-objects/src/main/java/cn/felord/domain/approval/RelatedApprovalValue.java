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

package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 关联审批单组件
 *
 * @author dax
 * @since 2023 /5/27
 */
@ToString
@Getter
public class RelatedApprovalValue implements ContentDataValue {

    private final Wrapper relatedApproval;

    /**
     * Instantiates a new Related approval value.
     *
     * @param relatedApproval the related approval
     */
    @JsonCreator
    RelatedApprovalValue(@JsonProperty("related_approval") Wrapper relatedApproval) {
        this.relatedApproval = relatedApproval;
    }

    /**
     * Instantiates a new Related approval value.
     *
     * @param spNo the sp no
     */
    public RelatedApprovalValue(List<String> spNo) {
        this(new Wrapper(spNo));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final List<String> spNo;

        /**
         * Instantiates a new Wrapper.
         *
         * @param spNo the sp no
         */
        @JsonCreator
        Wrapper(List<String> spNo) {
            this.spNo = spNo;
        }
    }
}
