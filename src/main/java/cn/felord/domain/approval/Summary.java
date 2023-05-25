package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/26
 */
@Data
public class Summary {
    private final List<ApprovalTitle> summaryInfo;
}
