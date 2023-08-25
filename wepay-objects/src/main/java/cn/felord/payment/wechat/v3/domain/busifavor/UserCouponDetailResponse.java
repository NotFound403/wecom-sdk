package cn.felord.payment.wechat.v3.domain.busifavor;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/8/25
 */
@Data
public class UserCouponDetailResponse {
    private List<CouponDetail> data;
    private Long totalCount;
    private Long limit;
    private Long offset;
}
