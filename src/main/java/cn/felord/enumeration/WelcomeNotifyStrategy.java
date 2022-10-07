package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Welcome notify strategy.
 *
 * @author dax
 * @since 2021/9/23 11:08
 */
public enum WelcomeNotifyStrategy {

    /**
     * Off welcome notify strategy.
     */
    OFF(0),

    ON(1);

    private final int type;

    WelcomeNotifyStrategy(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize moment create type.
     *
     * @param type the type
     * @return the moment create type
     */
    @JsonCreator
    public static WelcomeNotifyStrategy deserialize(int type) {
        return Arrays.stream(WelcomeNotifyStrategy.values())
                .filter(contactType -> contactType.type == type)
                .findFirst()
                .orElse(null);
    }
}
