package cn.felord.domain.approval;

import cn.felord.enumeration.SingleOrMulti;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 16:22
 */
@Data
@JsonTypeName("SelectorConfig")
public class SelectorConfig {
    private Wrapper selector;

    @Data
    public static class Wrapper {
        private SingleOrMulti type;
        private List<CtrlOption> options;
    }
}
