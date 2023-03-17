package cn.felord.domain.office.form;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2023/3/13 17:14
 */
@Data
public class FillInRange {
    private Set<String> userids;
    private Set<Long> departmentids;
}
