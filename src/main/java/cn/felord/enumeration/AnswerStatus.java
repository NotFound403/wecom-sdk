package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The FormItemStatus
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum AnswerStatus {

    /**
     * Normal form item status.
     */
    NORMAL(1),

    /**
     * Deleted form item status.
     */
    DELETED(2),
    /**
     * Invalid answer status.
     */
    INVALID(3);

    private final int type;

    AnswerStatus(int type) {
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
     * Deserialize button type.
     *
     * @param type the type
     * @return the button type
     */
    @JsonCreator
    public static AnswerStatus deserialize(int type) {
        return Arrays.stream(AnswerStatus.values())
                .filter(answerStatus -> answerStatus.type == type)
                .findFirst()
                .orElse(null);
    }
}
