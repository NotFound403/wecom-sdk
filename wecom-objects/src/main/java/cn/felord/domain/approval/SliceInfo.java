package cn.felord.domain.approval;

import cn.felord.enumeration.SliceState;
import lombok.Data;

import java.time.Duration;
import java.util.List;

/**
 * @author dax
 * @since 2023/12/19
 */
@Data
public class SliceInfo {
    private Duration duration;
    private SliceState state;
    private List<DayItem> dayItems;
}
