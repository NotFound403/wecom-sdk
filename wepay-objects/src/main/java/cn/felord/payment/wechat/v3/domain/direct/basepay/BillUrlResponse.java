package cn.felord.payment.wechat.v3.domain.direct.basepay;

import lombok.Data;

/**
 * @author felord.cn
 * @since 2023/8/17 17:19
 */
@Data
public class BillUrlResponse {
    private String downloadUrl;
    private String hashType;
    private String hashValue;
}
