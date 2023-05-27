package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/5/27 17:21
 */
@ToString
@Getter
public class FormulaValue implements ContentDataValue {
    private final Wrapper formula;

    @JsonCreator
    public FormulaValue(@JsonProperty Wrapper formula) {
        this.formula = formula;
    }

    @Data
    public static class Wrapper {
        private String value;
    }
}
