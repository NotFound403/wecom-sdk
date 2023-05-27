package cn.felord.domain.approval;

import lombok.Getter;

import java.util.List;

/**
 * The type Approval temp update request.
 *
 * @author dax
 * @since 2023 /5/25
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
