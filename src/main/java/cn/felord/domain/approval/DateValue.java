package cn.felord.domain.approval;

import cn.felord.enumeration.DateCtrlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/5/25 16:15
 */
@ToString
@Getter
public class DateValue implements ContentDataValue {
    private final Wrapper date;

    @JsonCreator
    public DateValue(@JsonProperty("date") Wrapper date) {
        this.date = date;
    }

    @Data
    public static class Wrapper {
        private DateCtrlType type;
        private Instant sTimestamp;
    }
}
