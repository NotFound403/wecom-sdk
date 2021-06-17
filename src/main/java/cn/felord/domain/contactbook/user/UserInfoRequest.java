package cn.felord.domain.contactbook.user;

import java.util.List;
import lombok.Data;

/**
 * @author n1
 */
@Data
public class UserInfoRequest {
	private String userid;
	private String name;
	private String address;
	private String gender;
	private String externalPosition;
	private String mobile;
	private List<Integer> isLeaderInDept;
	private String telephone;
	private Boolean toInvite;
	private Integer mainDepartment;
	private Integer enable;
	private String avatarMediaid;
	private String alias;
	private Extattr extattr;
	private String position;
	private List<Integer> department;
	private ExternalProfile externalProfile;
	private String email;
	private List<Integer> order;
}