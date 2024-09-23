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

import lombok.Getter;

import java.util.List;

/**
 * The type Approval temp update request.
 *
 * @author dax
 * @since 2024/5/25
 */
@Getter
public class ApprovalTempUpdateRequest {
    private final String templateId;
    private final List<ApprovalTitle> templateName;
    private final TemplateContent templateContent;

    public ApprovalTempUpdateRequest(String templateId, List<ApprovalTitle> templateName) {
        this(templateId, templateName, null);
    }

    /**
     * Instantiates a new Approval temp update request.
     *
     * @param templateId      the template id
     * @param templateName    the template name
     * @param templateContent the template content
     */
    public ApprovalTempUpdateRequest(String templateId,
                                     List<ApprovalTitle> templateName,
                                     TemplateContent templateContent) {
        this.templateId = templateId;
        this.templateName = templateName;
        this.templateContent = templateContent;
    }
}
