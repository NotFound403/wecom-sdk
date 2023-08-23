package cn.felord.payment.wechat.v3.domain.busifavor;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AssociateTime {
    /**
     * 系统关联券/取消关联券成功的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    @JsonAlias({"wechatpay_associate_time", "wechatpay_disassociate_time"})
    private OffsetDateTime wechatpayAssociateTime;
}
