package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 16:46
 */
@Data
public class VacationConfig {
    private Wrapper vacationList;

    @Data
    public static class Wrapper {
        private List<VacationItem> item;
    }
}
