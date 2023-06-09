package cn.felord.domain.urgentcall;

import lombok.Data;

/**
 * @author dax
 * @since 2023/6/9 15:41
 */
@Data
public class CallStateRequest {
    private final String calleeUserid;
    private final String callid;
}
