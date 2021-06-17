package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/17 16:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleUserResponse extends WeComResponse {
    private List<SimpleUser> userlist;
}
