package cn.felord.domain.message;

import lombok.Data;

/**
 * @author felord
 * @since 2022/11/22 16:01
 */
@Data
public abstract class MessageBody {
    private final String msgtype;
    private final String agentid;
}
