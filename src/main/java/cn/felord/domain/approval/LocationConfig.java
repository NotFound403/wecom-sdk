package cn.felord.domain.approval;

import lombok.Data;

/**
 * @author dax
 * @since 2023/5/25 17:11
 */
@Data
public class LocationConfig {
    private Wrapper location;

    @Data
    public static class Wrapper {
        private Integer distance;
    }
}
