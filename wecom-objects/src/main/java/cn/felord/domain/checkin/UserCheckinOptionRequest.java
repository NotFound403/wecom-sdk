package cn.felord.domain.checkin;

import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * @author dax
 * @since 2023/9/26
 */
@Data
public class UserCheckinOptionRequest {
    private final Instant datetime;
    private final Set<String> useridlist;
}
