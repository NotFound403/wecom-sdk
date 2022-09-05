package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author felord.cn
 * @since 2021/8/27 10:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserIdConvertResponse extends WeComResponse {
 private List<UserIdPair> useridList;
 private List<String> invalidOpenUseridList;
}
