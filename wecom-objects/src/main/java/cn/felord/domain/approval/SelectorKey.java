package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Selector key.
 *
 * @author dax
 * @since 2023 /9/12
 */
@ToString
@Getter
public class SelectorKey {
    private final String key;

    /**
     * Instantiates a new Selector key.
     *
     * @param key the key
     */
    @JsonCreator
    public SelectorKey(@JsonProperty("key") String key) {
        this.key = key;
    }
}