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

import cn.felord.enumeration.SpStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 关联审批单组件
 *
 * @author dax
 * @since 2024/5/27
 */
@ToString
@Getter
public class RelatedApprovalValue implements ContentDataValue {

    private final List<Wrapper> relatedApproval;

    /**
     * Instantiates a new Related approval value.
     *
     * @param relatedApproval the related approval
     */
    @JsonCreator
    RelatedApprovalValue(@JsonProperty("related_approval") List<Wrapper> relatedApproval) {
        this.relatedApproval = relatedApproval;
    }

    /**
     * Instantiates a new Related approval value.
     *
     * @param spNo the sp no
     * @return the related approval value
     */
    public static RelatedApprovalValue from(List<String> spNo) {
        List<Wrapper> wrappers = spNo.stream()
                .map(Wrapper::new)
                .collect(Collectors.toList());
        return new RelatedApprovalValue(wrappers);
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final String spNo;
        private final Instant createTime;
        private final String name;
        private final SpStatus spStatus;
        private final List<ApprovalTitle> templateNames;

        /**
         * Instantiates a new Wrapper.
         *
         * @param spNo the sp no
         */
        Wrapper(String spNo) {
            this(spNo, null, null, null, null);
        }

        /**
         * Instantiates a new Wrapper.
         *
         * @param spNo          the sp no
         * @param createTime    the create time
         * @param name          the name
         * @param spStatus      the sp status
         * @param templateNames the template names
         */
        @JsonCreator
        Wrapper(@JsonProperty("sp_no") String spNo,
                @JsonProperty("create_time") Instant createTime,
                @JsonProperty("name") String name,
                @JsonProperty("sp_status") SpStatus spStatus,
                @JsonProperty("template_names") List<ApprovalTitle> templateNames) {
            this.spNo = spNo;
            this.createTime = createTime;
            this.name = name;
            this.spStatus = spStatus;
            this.templateNames = templateNames;
        }
    }
}
