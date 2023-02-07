package cn.felord.domain.message;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author felord
 * @since 2021/11/22 11:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageResponse extends WeComResponse {
    private List<String> invaliduser;
    private List<String> invalidparty;
    private List<String> invalidtag;
    private List<String> unlicenseduser;
    private String msgid;
    private String responseCode;
}
