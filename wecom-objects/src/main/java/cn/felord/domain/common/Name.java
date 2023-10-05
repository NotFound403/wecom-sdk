package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Name.
 *
 * @author dax
 * @since 2023 /10/5
 */
@ToString
@Getter
public class Name {
    private final String name;

    /**
     * Instantiates a new Name.
     *
     * @param name the name
     */
    @JsonCreator
    public Name(@JsonProperty("name") String name) {
        this.name = name;
    }
}
