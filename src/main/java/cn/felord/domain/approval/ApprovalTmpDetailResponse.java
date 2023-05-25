package cn.felord.domain.approval;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 14:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApprovalTmpDetailResponse extends WeComResponse {
    private List<ApprovalTitle> templateNames;
    private TemplateContent templateContent;
}
