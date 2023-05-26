package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25
 */
@Getter
public class ApprovalTemplate {
    private final List<ApprovalTitle> templateName;
    private final TemplateContent templateContent;

    @JsonCreator
    public ApprovalTemplate(@JsonProperty("template_name") List<ApprovalTitle> templateName, @JsonProperty("template_content") TemplateContent templateContent) {
        this.templateName = templateName;
        this.templateContent = templateContent;
    }
}
