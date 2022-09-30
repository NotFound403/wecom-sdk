package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/8/23 11:03
 */
@Data
public class ApplicableRange {
    private List<String> userList;
    private List<Integer> departmentList;
}
