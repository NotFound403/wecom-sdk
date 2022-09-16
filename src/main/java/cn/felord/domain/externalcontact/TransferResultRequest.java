package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/14 14:42
 */
@Data
public class TransferResultRequest {
    private final String handoverUserid;
    private final String takeoverUserid;
    private String cursor;
}
