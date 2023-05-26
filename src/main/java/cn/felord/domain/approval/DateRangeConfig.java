package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/5/25 17:17
 */
@Data
@JsonTypeName("DateRangeConfig")
public class DateRangeConfig {
    private DateRange dateRange;
}
