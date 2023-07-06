package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class MiniPayRequest {
    private final String appid;
    private final String mchid;
    private final String outTradeNo;
    private final String description;
    private final Amount amount;
    private final Payer payer;
    private OffsetDateTime timeExpire;
    private String attach;
    private String goodsTag;
    private String scenekey;
    private PayOrderDetail detail;
    private SceneInfo sceneInfo;
}