package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25 16:24
 */
@Data
public class CtrlOption {
    private String key;
    private List<ApprovalTitle> value;
}
