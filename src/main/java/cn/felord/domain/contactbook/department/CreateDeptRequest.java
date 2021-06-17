package cn.felord.domain.contactbook.department;

import lombok.Data;

/**
 *
 * @author n1
 */
@Data
public class CreateDeptRequest {
    private String name;
    private Integer id;
    private Integer parentid;
    private String nameEn;
    private Integer order;
}