package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Form fork finish type.
 *
 * @author dax
 * @since 2023 /3/13 17:24
 */
public enum FormForkFinishType {
    /**
     * Allow form fork finish type.
     */
    ALLOW(0),
    /**
     * Same day form fork finish type.
     */
    SAME_DAY(1),
    /**
     * Five day form fork finish type.
     */
    FIVE_DAY(2),
    /**
     * One month form fork finish type.
     */
    ONE_MONTH(3),
    /**
     * Next form fork finish type.
     */
    NEXT(4);

    private final int type;

    FormForkFinishType(int type) {
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
     * Deserialize form fork finish type.
     *
     * @param type the type
     * @return the form fork finish type
     */
    @JsonCreator
    public static FormForkFinishType deserialize(int type) {
        return Arrays.stream(FormForkFinishType.values())
                .filter(formForkFinishType -> formForkFinishType.type == type)
                .findFirst()
                .orElse(null);
    }

}
