package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The SpStatus   org  roleid  tempid  filter
 *
 * @author felord
 * @since 2021 /11/23 17:01
 */
public enum SpStatus {

    /**
     * 审批中
     */
    APPROVAL(1),
    /**
     * 已通过
     */
    ACCEPTED(2),
    /**
     * 已驳回
     */
    REJECTED(3),
    /**
     * 已撤销
     */
    REVOKED(4),
    /**
     * 通过后撤销
     */
    REVOKE_AFTER_ADOPT(6),
    /**
     * 已删除
     */
    DELETED(7),
    /**
     * 已支付
     */
    PAYED(10);

    private final int type;

    SpStatus(int type) {
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
    public static SpStatus deserialize(int type) {
        return Arrays.stream(SpStatus.values())
                .filter(formItemStatus -> formItemStatus.type == type)
                .findFirst()
                .orElse(null);
    }
}
