package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/5/26
 */
@ToString
@Getter
public class NumberValue implements ContentDataValue {
    private final String newNumber;

    @JsonCreator
    public NumberValue(@JsonProperty("new_number") String newNumber) {
        this.newNumber = newNumber;
    }
}
