package cn.felord.domain.journal;

import cn.felord.domain.common.KV;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
@ToString
@Getter
public class JournalRecordRequest {
    private final Instant starttime;
    private final Instant endtime;
    private final Integer cursor;
    private final Integer limit;
    private List<KV> filters;

    public JournalRecordRequest(Instant starttime, Instant endtime, Integer limit, int cursor) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.cursor = cursor;
        this.limit = limit;
    }

    public JournalRecordRequest filters(List<KV> filters) {
        this.filters = filters;
        return this;
    }
}
