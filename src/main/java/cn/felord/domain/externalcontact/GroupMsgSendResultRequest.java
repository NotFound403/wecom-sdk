package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/22 16:57
 */
@Data
public class GroupMsgSendResultRequest {
    private final String msgid;
    private final String userid;
    private Integer limit;
    private String cursor;
}
