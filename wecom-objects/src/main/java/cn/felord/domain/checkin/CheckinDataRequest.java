package cn.felord.domain.checkin;

import cn.felord.enumeration.CheckinDataType;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * The type Checkin data request.
 */
@Data
public class CheckinDataRequest {
    private final CheckinDataType opencheckindatatype;
    private final Instant starttime;
    private final Instant endtime;
    private final Set<String> useridlist;
}