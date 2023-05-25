package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25
 */
@Data
public class ApprovalTemplate {
    private final List<ApprovalTitle> templateName;
    private final TemplateContent templateContent;
}
