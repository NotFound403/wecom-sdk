package cn.felord.domain.contactbook.user;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author xiafang
 * @since 2022/10/12 16:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeptUserListResponse extends CursorWeComResponse {
    private List<DeptUser> deptUser;
}
