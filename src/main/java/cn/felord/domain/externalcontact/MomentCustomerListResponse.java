package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author dax
 * @since 2021/10/20 13:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentCustomerListResponse extends WeComResponse {
    private String nextCursor;
    private Set<CustomerItem> customerList;

    @Data
    public static class CustomerItem {
        private String userid;
        private String externalUserid;
    }
}
