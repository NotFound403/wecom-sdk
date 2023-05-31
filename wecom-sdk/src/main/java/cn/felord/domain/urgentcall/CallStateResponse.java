package cn.felord.domain.urgentcall;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.CallReason;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;
import java.time.Instant;

/**
 * @author xiafang
 * @since 2023/5/31 12:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CallStateResponse extends WeComResponse {
    private BoolEnum istalked;
    private Instant calltime;
    private Duration talktime;
    private CallReason reason;
}
