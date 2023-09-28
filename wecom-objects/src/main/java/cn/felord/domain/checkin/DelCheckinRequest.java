package cn.felord.domain.checkin;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Clear checkin request.
 */
@ToString
@Getter
public class DelCheckinRequest {
    /**
     * 打卡规则id
     */
    private final Integer groupid;
    /**
     * 是否立即生效，默认false
     */
    private final Boolean effectiveNow;

    /**
     * Instantiates a new Clear checkin request.
     *
     * @param groupid the groupid
     */
    public DelCheckinRequest(Integer groupid) {
        this(groupid, false);
    }

    /**
     * Instantiates a new Clear checkin request.
     *
     * @param groupid      the groupid
     * @param effectiveNow the effective now
     */
    public DelCheckinRequest(Integer groupid, Boolean effectiveNow) {
        this.groupid = groupid;
        this.effectiveNow = effectiveNow;
    }
}