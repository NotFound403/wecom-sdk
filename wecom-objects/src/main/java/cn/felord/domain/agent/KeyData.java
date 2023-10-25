package cn.felord.domain.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Key data.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class KeyData implements WorkBenchBody {
    private final List<KData> items;

    /**
     * Instantiates a new Key data.
     *
     * @param items the items
     */
    @JsonCreator
    public KeyData(@JsonProperty("items") List<KData> items) {
        this.items = items;
    }
}
