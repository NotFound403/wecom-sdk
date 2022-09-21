package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/25 15:56
 */
@Data
public class MomentSenderList {
    private List<String> userList;
    private List<Integer> departmentList;
}
