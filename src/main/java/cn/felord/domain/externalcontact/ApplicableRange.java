package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author xiafang
 * @since 2022/9/26 11:03
 */
@Data
public class ApplicableRange {
    private Set<String> userList;
    private Set<Integer> departmentList;
}
