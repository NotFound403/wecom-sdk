package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/14 14:05
 */
@Data
public class OffTransferCustomerRequest {
    private final String handoverUserid;
    private final String takeoverUserid;
    private final Set<String> externalUserid;
}
