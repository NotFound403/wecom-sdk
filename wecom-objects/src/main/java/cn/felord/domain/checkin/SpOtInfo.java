package cn.felord.domain.checkin;

import cn.felord.enumeration.SpOtStatus;
import lombok.Data;

import java.time.Duration;
import java.util.List;

/**
 * @author dax
 * @since 2023/9/26
 */
@Data
public class SpOtInfo {
    /**
     * 状态：0-无加班；1-正常；2-缺时长
     */
    private SpOtStatus otStatus;
    /**
     * 加班时长
     */
    private Duration otDuration;
    /**
     * 加班不足的时长
     */
    private List<Duration> exceptionDuration;
}
