package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Table value.
 *
 * @author dax
 * @since 2023 /5/27 10:59
 */
@ToString
@Getter
public class TableValue implements ContentDataValue {
    private final List<Wrapper> children;

    @JsonCreator
    public TableValue(@JsonProperty("children") List<Wrapper> children) {
        this.children = children;
    }

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private List<TableInternalValue<? extends ContentDataValue>> list;
    }
}
