package cn.felord.domain.dial;

import cn.felord.enumeration.CallType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * The type Dial record.
 */
@Data
public class DialRecord {
    /**
     * 主叫用户
     */
    private Caller caller;
    /**
     * 总通话时长，单位为分钟
     */
    private Integer totalDuration;
    /**
     * 被叫用户
     */
    private List<Callee> callee;
    /**
     * 拨出时间
     */
    private Instant callTime;
    /**
     * 通话类型
     */
    private CallType callType;
}