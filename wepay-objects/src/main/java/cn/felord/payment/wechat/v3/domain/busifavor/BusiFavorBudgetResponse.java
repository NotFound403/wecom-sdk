package cn.felord.payment.wechat.v3.domain.busifavor;

import lombok.Data;

@Data
public class BusiFavorBudgetResponse {
    /**
     * 当前单天发放上限个数
     */
    private Integer maxCouponsByDay;
    /**
     * 批次当前最大发放个数
     */
    private Integer maxCoupons;
}