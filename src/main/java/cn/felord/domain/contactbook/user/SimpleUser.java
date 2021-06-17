package cn.felord.domain.contactbook.user;

import lombok.Data;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/17 16:34
 */
@Data
public class SimpleUser {
    private String userid;
    private String name;
    private List<Integer> department;
    private String openUserid;
}
