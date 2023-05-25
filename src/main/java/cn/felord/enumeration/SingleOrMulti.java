package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Date ctrl type.
 *
 * @author xiafang
 * @since 2023 /5/25 16:19
 */
public enum SingleOrMulti {


    /**
     * Single selector ctrl type.
     */
    SINGLE("single"),

    /**
     * Multi selector ctrl type.
     */
    MULTI("multi");
    private final String type;

    SingleOrMulti(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }


    /**
     * Deserialize date ctrl type.
     *
     * @param type the type
     * @return the date ctrl type
     */
    @JsonCreator
    public static SingleOrMulti deserialize(String type) {
        return Arrays.stream(SingleOrMulti.values())
                .filter(contactType -> contactType.type.equals(type))
                .findFirst()
                .orElse(null);
    }
}
