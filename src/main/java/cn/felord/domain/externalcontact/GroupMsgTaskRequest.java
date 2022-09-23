package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/22 16:57
 */
@Data
public class GroupMsgTaskRequest {
    private final String msgid;
    private Integer limit;
    private String cursor;
}
