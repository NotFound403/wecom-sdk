package cn.felord.domain.contactbook.user;

import java.util.List;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author n1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoResponse extends WeComResponse {
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