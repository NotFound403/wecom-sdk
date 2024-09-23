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

package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The type Template id.
 *
 * @author dax
 * @since 2023 /5/24 15:43
 */
@ToString
@Getter
public class TemplateId {
    private final String templateId;

    /**
     * Instantiates a new Template id.
     *
     * @param templateId the template id
     */
    @JsonCreator
    TemplateId(@JsonProperty("template_id") String templateId) {
        this.templateId = templateId;
    }

    /**
     * From template id.
     *
     * @param templateId the template id
     * @return the template id
     */
    @Deprecated
    public static TemplateId from(@NonNull String templateId) {
        return new TemplateId(templateId);
    }

    /**
     * Of template id.
     *
     * @param templateId the template id
     * @return the template id
     */
    public static TemplateId of(@NonNull String templateId) {
        return new TemplateId(templateId);
    }
}
