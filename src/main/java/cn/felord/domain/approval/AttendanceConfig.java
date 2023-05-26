package cn.felord.domain.approval;

import cn.felord.enumeration.AttendanceType;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/5/25 16:37
 */
@Data
@JsonTypeName("AttendanceConfig")
public class AttendanceConfig {
    private Wrapper attendance;

    @Data
    public static class Wrapper {
        private AttendanceType type;
        private DateRange dateRange;
    }
}
