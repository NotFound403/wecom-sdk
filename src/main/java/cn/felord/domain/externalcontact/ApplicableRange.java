package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2022/9/26 11:03
 */
@Data
public class ApplicableRange {
    private List<String> userList;
    private List<Integer> departmentList;
}
