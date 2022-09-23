package cn.felord.domain.contactbook.department;

import lombok.Data;

/**
 * @author felord.cn
 * @since 2021/9/2 16:21
 */
@Data
public class DeptSimpleInfo {
    private Integer id;
    private Integer parentid;
    private Long order;
}
