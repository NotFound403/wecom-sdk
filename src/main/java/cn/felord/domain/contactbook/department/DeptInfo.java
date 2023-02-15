package cn.felord.domain.contactbook.department;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author n1
 */
@Data
public class DeptInfo {
    private Long id;
    private Long parentid;
    private String name;
    private String nameEn;
    @Nullable
    private List<String> departmentLeader;
    private Long order;
}