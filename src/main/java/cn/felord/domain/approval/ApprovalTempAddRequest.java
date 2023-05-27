package cn.felord.domain.approval;

import lombok.Getter;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25
 */
@Getter
public class ApprovalTempAddRequest {
    private final List<ApprovalTitle> templateName;
    private final TemplateContent templateContent;

    public ApprovalTempAddRequest(List<ApprovalTitle> templateName, TemplateContent templateContent) {
        this.templateName = templateName;
        this.templateContent = templateContent;
    }
}
