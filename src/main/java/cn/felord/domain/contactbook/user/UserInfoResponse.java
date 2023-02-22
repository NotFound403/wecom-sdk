package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author n1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoResponse extends WeComResponse {
	private String userid;
	private String name;
	private String mobile;
	private List<Long> department;
	private List<Integer> order;
	private String position;
	private String gender;
	private String email;
	private String bizEmail;
	private List<Long> isLeaderInDept;
	private List<String> directLeader;
	private String avatar;
	private String thumbAvatar;
	private String telephone;
	private String alias;
	private Extattr extattr;
	private Integer status;
	private String qrCode;
	private ExternalProfile externalProfile;
	private String externalPosition;
	private String address;
	private String openUserid;
	private Long mainDepartment;
}