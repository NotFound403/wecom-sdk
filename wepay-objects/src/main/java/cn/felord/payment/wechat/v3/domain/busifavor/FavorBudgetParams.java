/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.felord.payment.wechat.v3.domain.busifavor;

import lombok.Getter;
import lombok.ToString;

/**
 * 修改商家券批次预算API请求参数
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class FavorBudgetParams {

    /**
     * 目标批次最大发放个数，同{@link #targetMaxCouponsByDay}二选一
     */
    private final Integer targetMaxCoupons;
    /**
     * 目标单天发放上限个数，同{@link #targetMaxCoupons}二选一
     */
    private final Integer targetMaxCouponsByDay;
    /**
     * 当前批次最大发放个数，当传入{@link #targetMaxCoupons}大于0时，必传
     */
    private Integer currentMaxCoupons;
    /**
     * 当前单天发放上限个数 ，当传入{@link #targetMaxCouponsByDay}大于0时，必填
     */
    private Integer currentMaxCouponsByDay;
    /**
     * 修改预算请求单据号
     */
    private final String modifyBudgetRequestNo;

    /**
     * Instantiates a new Busi favor budget params.
     *
     * @param targetMaxCoupons      the target max coupons
     * @param targetMaxCouponsByDay the target max coupons by day
     * @param modifyBudgetRequestNo the modify budget request no
     */
    FavorBudgetParams(Integer targetMaxCoupons, Integer targetMaxCouponsByDay, String modifyBudgetRequestNo) {
        this.targetMaxCoupons = targetMaxCoupons;
        this.targetMaxCouponsByDay = targetMaxCouponsByDay;
        this.modifyBudgetRequestNo = modifyBudgetRequestNo;
    }

    /**
     * With target max coupons by day busi favor budget params.
     *
     * @param targetMaxCouponsByDay the target max coupons by day
     * @param modifyBudgetRequestNo the modify budget request no
     * @return the busi favor budget params
     */
    public static FavorBudgetParams withTargetMaxCouponsByDay(Integer targetMaxCouponsByDay, String modifyBudgetRequestNo) {
        return new FavorBudgetParams(null, targetMaxCouponsByDay, modifyBudgetRequestNo);
    }

    /**
     * With target max coupons busi favor budget params.
     *
     * @param targetMaxCoupons      the target max coupons
     * @param modifyBudgetRequestNo the modify budget request no
     * @return the busi favor budget params
     */
    public static FavorBudgetParams withTargetMaxCoupons(Integer targetMaxCoupons, String modifyBudgetRequestNo) {
        return new FavorBudgetParams(targetMaxCoupons, null, modifyBudgetRequestNo);
    }

    /**
     * Current max coupons busi favor budget params.
     *
     * @param currentMaxCoupons the current max coupons
     * @return the busi favor budget params
     */
    public FavorBudgetParams currentMaxCoupons(Integer currentMaxCoupons) {
        this.currentMaxCoupons = currentMaxCoupons;
        return this;
    }

    /**
     * Current max coupons by day busi favor budget params.
     *
     * @param currentMaxCouponsByDay the current max coupons by day
     * @return the busi favor budget params
     */
    public FavorBudgetParams currentMaxCouponsByDay(Integer currentMaxCouponsByDay) {
        this.currentMaxCouponsByDay = currentMaxCouponsByDay;
        return this;
    }
}
