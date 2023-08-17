package cn.felord.domain.approval;

import lombok.Getter;
import lombok.ToString;

import java.time.Duration;

/**
 * 修改成员假期余额请求参数
 *
 * @author dax
 * @since 2023 /8/14
 */
@ToString
@Getter
public class UserQuotaSettingRequest {
    private final String userid;
    private final Long vacationId;
    private final Duration leftduration;
    private final String remarks;

    /**
     * Instantiates a new User quota request.
     *
     * @param userid       the userid
     * @param vacationId   the vacation id
     * @param leftduration the leftduration
     */
    public UserQuotaSettingRequest(String userid, Long vacationId, Duration leftduration) {
        this(userid, vacationId, leftduration, null);
    }

    /**
     * Instantiates a new User quota request.
     *
     * @param userid       the userid
     * @param vacationId   the vacation id
     * @param leftduration the leftduration
     * @param remarks      the remarks
     */
    public UserQuotaSettingRequest(String userid, Long vacationId, Duration leftduration, String remarks) {
        this.userid = userid;
        this.vacationId = vacationId;
        this.leftduration = leftduration;
        this.remarks = remarks;
    }
}
