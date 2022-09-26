package cn.felord.domain.externalcontact;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2021/7/14 14:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TransferCustomerResponse extends WeComResponse {
    private List<Customer> customer;

    @Data
    public static class Customer {
        private String externalUserid;
        private Integer errcode;
    }
}
