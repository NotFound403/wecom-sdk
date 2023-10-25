package cn.felord.domain.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Items.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class Items implements WorkBenchBody {
    private final List<Item> items;

    /**
     * Instantiates a new Items.
     *
     * @param items the items
     */
    @JsonCreator
    public Items(@JsonProperty("items") List<Item> items) {
        this.items = items;
    }
}
