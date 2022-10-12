package cn.felord.domain.externalcontact;

import cn.felord.domain.CursorWeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/10/20 13:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MomentCustomerListResponse extends CursorWeComResponse {
    private List<CustomerItem> customerList;

    @Data
    public static class CustomerItem {
        private String userid;
        private String externalUserid;
    }
}
