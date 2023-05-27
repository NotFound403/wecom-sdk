package cn.felord.domain.approval;

import cn.felord.domain.KV;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/5/27 14:36
 */
@Data
public class SpNoListRequest {
    private final Instant starttime;
    private final Instant endtime;
    private final Integer cursor;
    private final Integer size;
    private List<KV> filters;
}
