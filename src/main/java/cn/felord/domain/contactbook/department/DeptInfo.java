package cn.felord.domain.contactbook.department;

import lombok.Data;

/**
 * @author n1
 */
@Data
public class DeptInfo {
    private Long id;
    private Long parentid;
    private String name;
    private String nameEn;
    private Long order;
}