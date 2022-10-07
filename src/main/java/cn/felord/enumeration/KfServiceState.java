package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The enum Kf service state.
 *
 * @author dax
 * @since 2021/9/30 13:41
 */
public enum KfServiceState {

    /**
     * Untreated kf service state.
     */
    UNTREATED(0),
    SMART_ASSISTANT(1),
    /**
     * Line up kf service state.
     */
    LINE_UP(2),
    /**
     * Manual kf service state.
     */
    MANUAL(3),
    /**
     * Finished or not started kf service state.
     */
    FINISHED_OR_NOT_STARTED(4);

    private final int state;

    KfServiceState(int state) {
        this.state = state;
    }


    /**
     * Gets state.
     *
     * @return the state
     */
    @JsonValue
    public int getState() {
        return state;
    }

    /**
     * Deserialize kf service state.
     *
     * @param state the state
     * @return the kf service state
     */
    @JsonCreator
    public static KfServiceState deserialize(int state) {
        return Arrays.stream(KfServiceState.values())
                .filter(contactType -> contactType.state == state)
                .findFirst()
                .orElse(null);
    }
}
