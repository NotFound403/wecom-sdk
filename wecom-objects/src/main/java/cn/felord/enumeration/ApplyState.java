package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 申请阶段对应关系
 *
 * @author dax
 * @since 2023 /7/3 16:20
 */
public enum ApplyState {
    /**
     * 初始状态
     */
    INITIAL(0),
    /**
     * 申请中
     */
    APPLYING(1),
    /**
     * 绑定成功
     */
    BOUND_SUCCESS(2),
    /**
     * 已撤销申请
     */
    REVOKE(3),
    /**
     * 绑定失败
     */
    BOUND_FAIL(4),
    /**
     * 未申请
     */
    NOT_APPLIED(5),
    /**
     * 待法人验证
     */
    TO_LEGAL_VERIFY(6);

    private final int state;

    ApplyState(int state) {
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
     * Deserialize ApplyState
     *
     * @param state the state
     * @return the kf service state
     */
    @JsonCreator
    public static ApplyState deserialize(int state) {
        return Arrays.stream(ApplyState.values())
                .filter(applyState -> applyState.state == state)
                .findFirst()
                .orElse(null);
    }
}
