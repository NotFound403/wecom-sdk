package cn.felord.domain.approval;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 16:50
 */
@Data
public class TableConfig {
    private Wrapper table;

    @Data
    public static class Wrapper {
        private BoolEnum printFormat;
        private List<TableCtrlProperty> children;
    }
}
