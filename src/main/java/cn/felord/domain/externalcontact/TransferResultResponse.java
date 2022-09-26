package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.TakeoverStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/14 14:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TransferResultResponse extends WeComResponse {
    private List<Customer> customer;
    private String nextCursor;

    @Data
    public static class Customer {
        private String externalUserid;
        private TakeoverStatus status;
        private Instant takeoverTime;
    }
}
