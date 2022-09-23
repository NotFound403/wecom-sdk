package cn.felord.domain.contactbook.department;

import lombok.Data;

/**
 *
 * @author n1
 */
@Data
public class DeptInfo{
    private Integer id;
    private Integer parentid;
    private String name;
    private String nameEn;
    private Long order;
}