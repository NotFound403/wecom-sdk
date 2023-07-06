package cn.felord.domain.corpay.miniapppay;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@Data
public class PayOrderDetail {
    private String invoiceId;
    private Integer costPrice;
    private List<GoodsDetailItem> goodsDetail;
}