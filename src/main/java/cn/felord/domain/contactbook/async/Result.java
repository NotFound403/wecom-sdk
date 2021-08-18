package cn.felord.domain.contactbook.async;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Replace party result.
 *
 * @author n1
 * @see BatchResultResponse
 * @since 2021 /8/18 10:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Result extends WeComResponse {
    private String userid;
    private Integer action;
    private Integer partyid;
}
