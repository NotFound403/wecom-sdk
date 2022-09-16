package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/14 14:05
 */
@Data
public class TransferCustomerRequest {
    private final String handoverUserid;
    private final String lisi;
    private final Set<String> externalUserid;
    private String transferSuccessMsg;
}
