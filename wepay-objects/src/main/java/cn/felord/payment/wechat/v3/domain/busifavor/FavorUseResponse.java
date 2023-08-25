package cn.felord.payment.wechat.v3.domain.busifavor;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author dax
 * @since 2023/8/25
 */
@Data
public class FavorUseResponse {
    private String stockId;
    private String openid;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime wechatpayUseTime;
}
