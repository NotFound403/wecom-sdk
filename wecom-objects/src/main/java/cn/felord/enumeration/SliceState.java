package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 时长计算来源类型
 *
 * @author dax
 * @since 2023 /12/19
 */
public enum SliceState {
    /**
     * 系统自动计算
     */
    SYS(1),
    /**
     * 用户修改
     */
    SELF(2);

    private final int state;

    SliceState(int state) {
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
     * Deserialize slice state.
     *
     * @param state the state
     * @return the slice state
     */
    @JsonCreator
    public static SliceState deserialize(int state) {
        return Arrays.stream(SliceState.values())
                .filter(sliceState -> sliceState.state == state)
                .findFirst()
                .orElse(null);
    }
}
