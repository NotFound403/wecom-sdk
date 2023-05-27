package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25 16:47
 */
@Data
public class VacationItem {
    private Integer id;
    private List<ApprovalTitle> name;

}
