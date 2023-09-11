package cn.felord.payment.wechat.v3.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2023/8/25
 */
@Data
public class GenericPayResponse<T> {
    @JsonAlias({
            "wechatpay_return_time",
            "wechatpay_deactivate_time"
    })
    private T data;
}
