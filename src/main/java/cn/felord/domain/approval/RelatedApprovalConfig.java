package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25 17:15
 */
@Data
public class RelatedApprovalConfig {
    private Wrapper relatedApproval;

    @Data
    public static class Wrapper {
        private List<String> templateId;
    }
}
