package cn.felord.domain.contactbook.user;

import lombok.Data;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/17 16:53
 */
@Data
public class UserDetail {
    private String address;
    private String gender;
    private String externalPosition;
    private String mobile;
    private List<Integer> isLeaderInDept;
    private String telephone;
    private String avatar;
    private Integer mainDepartment;
    private String userid;
    private String thumbAvatar;
    private String name;
    private String alias;
    private Extattr extattr;
    private String qrCode;
    private String position;
    private List<Integer> department;
    private String openUserid;
    private ExternalProfile externalProfile;
    private String email;
    private List<Integer> order;
    private Integer status;
}
