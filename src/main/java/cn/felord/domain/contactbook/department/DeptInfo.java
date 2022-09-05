package cn.felord.domain.contactbook.department;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author n1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeptInfo extends DeptSimpleInfo {
    private String name;
    private String nameEn;
}