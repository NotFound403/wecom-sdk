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

import cn.felord.payment.wechat.enumeration.BusiFavorUseMethod;
import cn.felord.payment.wechat.enumeration.StockType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 商家券核销规则
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class CouponUseRule {

    /**
     * 核销方式
     */
    private final BusiFavorUseMethod useMethod;
    /**
     * 换购券使用规则
     *
     * @see StockType#EXCHANGE
     */
    private final ExchangeCoupon exchangeCoupon;
    /**
     * 券可核销时间
     */
    private final CouponAvailableTime couponAvailableTime;
    /**
     * 核销小程序appid
     *
     * @see BusiFavorUseMethod#MINI_PROGRAMS
     */
    private String miniProgramsAppid;
    /**
     * 核销小程序path
     *
     * @see #miniProgramsAppid
     */
    private String miniProgramsPath;
    /**
     * 固定面额满减券使用规则
     *
     * @see StockType#NORMAL
     */
    private final FixedNormalCoupon fixedNormalCoupon;
    /**
     * 折扣券使用规则
     *
     * @see StockType#DISCOUNT
     */
    private final DiscountCoupon discountCoupon;

    /**
     * Exchange coupon coupon use rule.
     *
     * @param useMethod      the use method
     * @param availableTime  the available time
     * @param exchangeCoupon the exchange coupon
     * @return the coupon use rule
     */
    static CouponUseRule exchangeCoupon(BusiFavorUseMethod useMethod, CouponAvailableTime availableTime, ExchangeCoupon exchangeCoupon) {
        return new CouponUseRule(useMethod, availableTime, exchangeCoupon, null, null);
    }

    /**
     * Fixed normal coupon coupon use rule.
     *
     * @param useMethod         the use method
     * @param availableTime     the available time
     * @param fixedNormalCoupon the fixed normal coupon
     * @return the coupon use rule
     */
    static CouponUseRule fixedNormalCoupon(BusiFavorUseMethod useMethod, CouponAvailableTime availableTime, FixedNormalCoupon fixedNormalCoupon) {
        return new CouponUseRule(useMethod, availableTime, null, fixedNormalCoupon, null);
    }

    /**
     * Fixed normal coupon coupon use rule.
     *
     * @param useMethod      the use method
     * @param availableTime  the available time
     * @param discountCoupon the discount coupon
     * @return the coupon use rule
     */
    static CouponUseRule discountCoupon(BusiFavorUseMethod useMethod, CouponAvailableTime availableTime, DiscountCoupon discountCoupon) {
        return new CouponUseRule(useMethod, availableTime, null, null, discountCoupon);
    }

    /**
     * Instantiates a new Coupon use rule.
     *
     * @param useMethod           the use method
     * @param couponAvailableTime the coupon available time
     * @param exchangeCoupon      the exchange coupon
     * @param fixedNormalCoupon   the fixed normal coupon
     * @param discountCoupon      the discount coupon
     */
    CouponUseRule(BusiFavorUseMethod useMethod,
                  CouponAvailableTime couponAvailableTime,
                  ExchangeCoupon exchangeCoupon,
                  FixedNormalCoupon fixedNormalCoupon,
                  DiscountCoupon discountCoupon) {
        this.useMethod = useMethod;
        this.couponAvailableTime = couponAvailableTime;
        this.exchangeCoupon = exchangeCoupon;
        this.fixedNormalCoupon = fixedNormalCoupon;
        this.discountCoupon = discountCoupon;
    }

    @JsonCreator
    CouponUseRule(@JsonProperty("use_method") BusiFavorUseMethod useMethod,
                  @JsonProperty("exchange_coupon") ExchangeCoupon exchangeCoupon,
                  @JsonProperty("coupon_available_time") CouponAvailableTime couponAvailableTime,
                  @JsonProperty("mini_programs_appid") String miniProgramsAppid,
                  @JsonProperty("mini_programs_path") String miniProgramsPath,
                  @JsonProperty("fixed_normal_coupon") FixedNormalCoupon fixedNormalCoupon,
                  @JsonProperty("discount_coupon") DiscountCoupon discountCoupon) {
        this.useMethod = useMethod;
        this.exchangeCoupon = exchangeCoupon;
        this.couponAvailableTime = couponAvailableTime;
        this.miniProgramsAppid = miniProgramsAppid;
        this.miniProgramsPath = miniProgramsPath;
        this.fixedNormalCoupon = fixedNormalCoupon;
        this.discountCoupon = discountCoupon;
    }

    /**
     * Mini programs appid coupon use rule.
     *
     * @param miniProgramsAppid the mini programs appid
     * @return the coupon use rule
     */
    CouponUseRule miniProgramsAppid(String miniProgramsAppid) {
        this.miniProgramsAppid = miniProgramsAppid;
        return this;
    }

    /**
     * Mini programs path coupon use rule.
     *          SERVER_IPv4 = "8.131.94.30"          DEPLOY_DIR = "www/admin/localhost_80/wwwroot"
     * @param miniProgramsPath the mini programs path
     * @return the coupon use rule
     */
    CouponUseRule miniProgramsPath(String miniProgramsPath) {
        this.miniProgramsPath = miniProgramsPath;
        return this;
    }
}
