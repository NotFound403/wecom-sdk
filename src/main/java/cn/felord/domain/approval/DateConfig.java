package cn.felord.domain.approval;

import cn.felord.enumeration.DateCtrlType;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/5/25 16:15
 */
@Data
@JsonTypeName("DateConfig")
public class DateConfig {
    private Wrapper date;


    @Data
    public static class Wrapper {
        private DateCtrlType type;
    }
}
