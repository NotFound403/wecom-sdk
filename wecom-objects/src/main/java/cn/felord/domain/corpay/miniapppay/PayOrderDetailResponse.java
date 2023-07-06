package cn.felord.domain.corpay.miniapppay;

import cn.felord.enumeration.MiniPayTradeState;
import cn.felord.enumeration.MiniPayTradeType;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class PayOrderDetailResponse {
    private String mchid;
    private String outTradeNo;
    private MiniPayTradeType tradeType;
    private MiniPayTradeState tradeState;
    private String tradeStateDesc;
    private Payer payer;
    private String transactionId;
    private String bankType;
    private String attach;
    private OffsetDateTime successTime;
    private OrderAmount amount;
    private SceneInfo sceneInfo;
    private PromotionDetail promotionDetail;
}