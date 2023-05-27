package cn.felord.domain.approval;

import cn.felord.enumeration.SingleOrMulti;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/25 16:22
 */
@ToString
@Getter
public class SelectorConfig implements ContentDataValue {
    private final Wrapper selector;

    @JsonCreator
    public SelectorConfig(@JsonProperty("selector") Wrapper selector) {
        this.selector = selector;
    }

    @Data
    public static class Wrapper {
        private SingleOrMulti type;
        private List<CtrlOption> options;
    }
}
