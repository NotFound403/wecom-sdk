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
import lombok.ToString;

import java.util.List;

/**
 * The type Related approval config.
 *
 * @author dax
 * @since 2024/5/25 17:15
 */
@ToString
@Getter
public class RelatedApprovalConfig implements ControlConfig {
    private final Wrapper relatedApproval;

    /**
     * Instantiates a new Related approval config.
     *
     * @param relatedApproval the related approval
     */
    @JsonCreator
    RelatedApprovalConfig(@JsonProperty("related_approval") Wrapper relatedApproval) {
        this.relatedApproval = relatedApproval;
    }

    /**
     * From related approval config.
     *
     * @param templateId the template id
     * @return the related approval config
     */
    public static RelatedApprovalConfig from(List<String> templateId) {
        return new RelatedApprovalConfig(new Wrapper(templateId));
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final List<String> templateId;

        /**
         * Instantiates a new Wrapper.
         *
         * @param templateId the template id
         */
        @JsonCreator
        Wrapper(@JsonProperty("template_id") List<String> templateId) {
            this.templateId = templateId;
        }
    }
}
