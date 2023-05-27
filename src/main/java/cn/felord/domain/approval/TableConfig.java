package cn.felord.domain.approval;

import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25 16:50
 */
@Data
@JsonTypeName("TableConfig")
public class TableConfig {
    private Wrapper table;

    @Data
    public static class Wrapper {
        private BoolEnum printFormat;
        private List<TableCtrlProperty> children;
        private List<String> statField;
        private List<String> sumField;
    }
}
