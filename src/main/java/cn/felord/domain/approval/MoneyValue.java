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
public class MoneyValue implements ContentDataValue {
    private final String newMoney;

    @JsonCreator
    public MoneyValue(@JsonProperty("new_money") String newMoney) {
        this.newMoney = newMoney;
    }
}
