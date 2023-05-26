package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/5/25 17:11
 */
@Data
@JsonTypeName("LocationConfig")
public class LocationConfig {
    private Wrapper location;

    @Data
    public static class Wrapper {
        private Integer distance;
    }
}
