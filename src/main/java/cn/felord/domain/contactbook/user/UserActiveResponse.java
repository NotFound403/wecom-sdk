package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author n1
 * @since 2021/6/17 18:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserActiveResponse extends WeComResponse {
    private Integer activeCnt;
}
