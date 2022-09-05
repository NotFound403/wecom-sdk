package cn.felord.domain.contactbook.user;

import lombok.Data;

import java.util.List;

/**
 * @author felord.cn
 * @since 2021/8/27 10:47
 */
@Data
public class UserIdConvertRequest {
 private List<String> openUseridList;
 private Integer sourceAgentId;
}
