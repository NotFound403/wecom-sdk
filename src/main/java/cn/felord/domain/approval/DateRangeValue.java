package cn.felord.domain.approval;

import cn.felord.enumeration.DateRangeType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Duration;
import java.time.Instant;

/**
 * @author dax
 * @since 2023/5/27
 */
@Data
public class DateRangeValue implements ContentDataValue{

    private final Wrapper dateRange;

    @JsonCreator
    public DateRangeValue(@JsonProperty("date_range") Wrapper dateRange) {
        this.dateRange = dateRange;
    }

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private  DateRangeType type;
        private Instant newBegin;
        private Instant newEnd;
        private Duration newDuration;
    }

}
