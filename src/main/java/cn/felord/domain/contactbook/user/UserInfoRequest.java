package cn.felord.domain.contactbook.user;

import lombok.Data;

import java.util.List;

/**
 * @author n1
 */
@Data
public class UserInfoRequest {
	private String userid;
	private String name;
	private String alias;
	private String mobile;
	private List<Integer> department;
	private List<Integer> order;
	private String position;
	private Integer gender;
	private String email;
	private String bizMail;
	private String telephone;
	private List<Integer> isLeaderInDept;
	private List<String> directLeader;
	private String avatarMediaid;
	private Integer enable;
	private Extattr extattr;
	private Boolean toInvite;
	private ExternalProfile externalProfile;
	private String externalPosition;
	private String nickname;
	private String address;
	private Integer mainDepartment;
}