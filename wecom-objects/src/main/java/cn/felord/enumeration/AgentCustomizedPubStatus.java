package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * The AgentCustomizedPubStatus
 *
 * @author dax
 * @since 2023 /7/3 10:55
 */
public enum AgentCustomizedPubStatus {

    /**
     * 待开发（企业已授权，服务商未创建应用）
     */
    TO_DEVELOP(0),

    /**
     * 开发中（服务商已创建应用，未上线）
     */
    DEVELOPING(1),
    /**
     * 已上线（服务商已上线应用且不存在未上线版本）
     */
    ONLINE_ALL(2),
    /**
     * 存在未上线版本（服务商已上线应用但存在未上线版本）
     */
    ONLINE_PARTIALLY(3);

    private final int status;

    AgentCustomizedPubStatus(int status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @JsonValue
    public int getStatus() {
        return status;
    }

    /**
     * Deserialize AgentCustomizedPubStatus
     *
     * @param status the status
     * @return the moment task status
     */
    @JsonCreator
    public static AgentCustomizedPubStatus deserialize(int status) {
        return Arrays.stream(AgentCustomizedPubStatus.values())
                .filter(pubStatus -> pubStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
