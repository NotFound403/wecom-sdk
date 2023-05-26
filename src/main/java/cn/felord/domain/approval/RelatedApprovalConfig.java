package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 17:15
 */
@Data
@JsonTypeName("RelatedApprovalConfig")
public class RelatedApprovalConfig {
    private Wrapper relatedApproval;

    @Data
    public static class Wrapper {
        private List<String> templateId;
    }
}
