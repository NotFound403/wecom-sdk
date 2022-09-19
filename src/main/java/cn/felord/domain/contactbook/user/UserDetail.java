package cn.felord.domain.contactbook.user;

import cn.felord.enumeration.UserStatus;
import lombok.Data;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/17 16:53
 */
@Data
public class UserDetail {
    private String userid;
    private String name;
    private String mobile;
    private List<Integer> department;
    private List<Integer> order;
    private String position;
    private String gender;
    private String email;
    private String bizMail;
    private List<Integer> isLeaderInDept;
    private List<String> directLeader;
    private String avatar;
    private String thumbAvatar;
    private String telephone;
    private String alias;
    private UserStatus status;
    private Extattr extattr;
    private String qrCode;
    private ExternalProfile externalProfile;
    private String externalPosition;
    private String address;
    private String openUserid;
    private Integer mainDepartment;
    private Integer hideMobile;
    private String englishName;

}
