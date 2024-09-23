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

import cn.felord.payment.wechat.enumeration.StockType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 商家券发放规则.
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class StockSendRule {

    /**
     * 批次最大发放个数
     * <p>
     * 特殊规则：取值范围 1 ≤ maxCoupons ≤ 1000000000
     */
    private Integer maxCoupons;
    /**
     * 用户最大可领个数
     * <p>
     * 每个用户最多100张券 。
     */
    private Integer maxCouponsPerUser;
    /**
     * 单天发放上限个数
     * <p>
     * {@link StockType#DISCOUNT}或者{@link StockType#DISCOUNT}时可传入此字段控制单天发放上限
     * <p>
     * 特殊规则：取值范围 1 ≤ maxCouponsByDay ≤ 1000000000
     */
    private Integer maxCouponsByDay;
    /**
     * 是否开启自然人限制
     */
    private Boolean naturalPersonLimit;
    /**
     * 可疑账号拦截
     */
    private Boolean preventApiAbuse;
    /**
     * 是否允许转赠
     */
    private Boolean transferable;
    /**
     * 是否允许分享链接
     */
    private Boolean shareable;

    /**
     * Instantiates a new Stock send rule.
     *
     * @param maxCoupons         the max coupons
     * @param maxCouponsPerUser  the max coupons per user
     * @param maxCouponsByDay    the max coupons by day
     * @param naturalPersonLimit the natural person limit
     * @param preventApiAbuse    the prevent api abuse
     * @param transferable       the transferable
     * @param shareable          the shareable
     */
    @JsonCreator
    StockSendRule(@JsonProperty("max_coupons") Integer maxCoupons,
                  @JsonProperty("max_coupons_per_user") Integer maxCouponsPerUser,
                  @JsonProperty("max_coupons_by_day") Integer maxCouponsByDay,
                  @JsonProperty("natural_person_limit") Boolean naturalPersonLimit,
                  @JsonProperty("prevent_api_abuse") Boolean preventApiAbuse,
                  @JsonProperty("transferable") Boolean transferable,
                  @JsonProperty("shareable") Boolean shareable) {
        this.maxCoupons = maxCoupons;
        this.maxCouponsPerUser = maxCouponsPerUser;
        this.maxCouponsByDay = maxCouponsByDay;
        this.naturalPersonLimit = naturalPersonLimit;
        this.preventApiAbuse = preventApiAbuse;
        this.transferable = transferable;
        this.shareable = shareable;
    }

    public StockSendRule() {
    }

    /**
     * Max coupons stock send rule.
     *
     * @param maxCoupons the max coupons
     * @return the stock send rule
     */
    public StockSendRule maxCoupons(Integer maxCoupons) {
        this.maxCoupons = maxCoupons;
        return this;
    }

    /**
     * Max coupons per user stock send rule.
     *
     * @param maxCouponsPerUser the max coupons per user
     * @return the stock send rule
     */
    public StockSendRule maxCouponsPerUser(Integer maxCouponsPerUser) {
        this.maxCouponsPerUser = maxCouponsPerUser;
        return this;
    }

    /**
     * Max coupons by day stock send rule.
     *
     * @param maxCouponsByDay the max coupons by day
     * @return the stock send rule
     */
    public StockSendRule maxCouponsByDay(Integer maxCouponsByDay) {
        this.maxCouponsByDay = maxCouponsByDay;
        return this;
    }

    /**
     * Natural person limit stock send rule.
     *
     * @param naturalPersonLimit the natural person limit
     * @return the stock send rule
     */
    public StockSendRule naturalPersonLimit(Boolean naturalPersonLimit) {
        this.naturalPersonLimit = naturalPersonLimit;
        return this;
    }

    /**
     * Prevent api abuse stock send rule.
     *
     * @param preventApiAbuse the prevent api abuse
     * @return the stock send rule
     */
    public StockSendRule preventApiAbuse(Boolean preventApiAbuse) {
        this.preventApiAbuse = preventApiAbuse;
        return this;
    }

    /**
     * Transferable stock send rule.
     *
     * @param transferable the transferable
     * @return the stock send rule
     */
    public StockSendRule transferable(Boolean transferable) {
        this.transferable = transferable;
        return this;
    }

    /**
     * Shareable stock send rule.
     *
     * @param shareable the shareable
     * @return the stock send rule
     */
    public StockSendRule shareable(Boolean shareable) {
        this.shareable = shareable;
        return this;
    }
}
