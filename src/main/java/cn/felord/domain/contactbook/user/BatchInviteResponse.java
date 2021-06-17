package cn.felord.domain.contactbook.user;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/17 17:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BatchInviteResponse extends WeComResponse {
    private List<String> invaliduser;
    private List<String> invalidparty;
    private List<String> invalidtag;
}
