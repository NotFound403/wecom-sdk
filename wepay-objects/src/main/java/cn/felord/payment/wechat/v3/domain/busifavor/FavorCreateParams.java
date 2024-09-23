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
import cn.felord.payment.wechat.enumeration.CouponCodeMode;
import cn.felord.payment.wechat.enumeration.StockType;
import lombok.Getter;
import lombok.ToString;

/**
 * 创建商家券请求参数.
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@Getter
public class FavorCreateParams {

    /**
     * 商家券批次名称,[1,21],必填
     */
    private final String stockName;
    /**
     * 批次归属商户号,必填
     */
    private final String belongMerchant;
    /**
     * 适用商品范围,必填
     * <p>
     * 用来描述批次在哪些商品可用，会显示在微信卡包中。字数上限为15个，一个中文汉字/英文字母/数字均占用一个字数。
     */
    private final String goodsName;
    /**
     * 批次备注,[1,20],选填
     */
    private String comment;
    /**
     * 批次类型
     */
    private final StockType stockType;
    /**
     * 核销规则
     */
    private final CouponUseRule couponUseRule;
    /**
     * 自定义入口
     */
    private CustomEntrance customEntrance;
    /**
     * 商家券code模式枚举
     */
    private final CouponCodeMode couponCodeMode;
    /**
     * 样式信息
     */
    private DisplayPatternInfo displayPatternInfo;
    /**
     * 券发放规则
     */
    private final StockSendRule stockSendRule;
    /**
     * 商户请求单号
     * <p>
     * 商户创建批次凭据号（格式：商户id+日期+流水号），商户侧需保持唯一性。
     */
    private final String outRequestNo;
    /**
     * 事件通知配置
     */
    private FavorNotifyConfig notifyConfig;
    /**
     * 是否允许营销补贴
     */
    private Boolean subsidy;


    /**
     * 满减券
     *
     * @param stockName         the stock name
     * @param belongMerchant    the belong merchant
     * @param goodsName         the goods name
     * @param useMethod         the use method
     * @param availableTime     the available time
     * @param fixedNormalCoupon the fixed normal coupon
     * @param couponCodeMode    the coupon code mode
     * @param stockSendRule     the stock send rule
     * @param outRequestNo      the out request no
     * @return the favor create params
     */
    public static FavorCreateParams normal(String stockName,
                                           String belongMerchant,
                                           String goodsName,
                                           BusiFavorUseMethod useMethod,
                                           CouponAvailableTime availableTime,
                                           FixedNormalCoupon fixedNormalCoupon,
                                           CouponCodeMode couponCodeMode,
                                           StockSendRule stockSendRule,
                                           String outRequestNo) {
        return new FavorCreateParams(stockName,
                belongMerchant,
                goodsName,
                StockType.NORMAL,
                CouponUseRule.fixedNormalCoupon(useMethod, availableTime, fixedNormalCoupon),
                couponCodeMode,
                stockSendRule,
                outRequestNo);
    }

    /**
     * 折扣券
     *
     * @param stockName      the stock name
     * @param belongMerchant the belong merchant
     * @param goodsName      the goods name
     * @param useMethod      the use method
     * @param availableTime  the available time
     * @param discountCoupon the discount coupon
     * @param couponCodeMode the coupon code mode
     * @param stockSendRule  the stock send rule
     * @param outRequestNo   the out request no
     * @return the favor create params
     */
    public static FavorCreateParams discount(String stockName,
                                             String belongMerchant,
                                             String goodsName,
                                             BusiFavorUseMethod useMethod,
                                             CouponAvailableTime availableTime,
                                             DiscountCoupon discountCoupon,
                                             CouponCodeMode couponCodeMode,
                                             StockSendRule stockSendRule,
                                             String outRequestNo) {
        return new FavorCreateParams(stockName,
                belongMerchant,
                goodsName,
                StockType.DISCOUNT,
                CouponUseRule.discountCoupon(useMethod, availableTime, discountCoupon),
                couponCodeMode,
                stockSendRule,
                outRequestNo);
    }

    /**
     * 换购券
     *
     * @param stockName      the stock name
     * @param belongMerchant the belong merchant
     * @param goodsName      the goods name
     * @param useMethod      the use method
     * @param availableTime  the available time
     * @param exchangeCoupon the exchange coupon
     * @param couponCodeMode the coupon code mode
     * @param stockSendRule  the stock send rule
     * @param outRequestNo   the out request no
     * @return the favor create params
     */
    public static FavorCreateParams exchange(String stockName,
                                             String belongMerchant,
                                             String goodsName,
                                             BusiFavorUseMethod useMethod,
                                             CouponAvailableTime availableTime,
                                             ExchangeCoupon exchangeCoupon,
                                             CouponCodeMode couponCodeMode,
                                             StockSendRule stockSendRule,
                                             String outRequestNo) {
        return new FavorCreateParams(stockName,
                belongMerchant,
                goodsName,
                StockType.EXCHANGE,
                CouponUseRule.exchangeCoupon(useMethod, availableTime, exchangeCoupon),
                couponCodeMode,
                stockSendRule,
                outRequestNo);
    }

    /**
     * Instantiates a new Favor create params.
     *
     * @param stockName      the stock name
     * @param belongMerchant the belong merchant
     * @param goodsName      the goods name
     * @param stockType      the stock type
     * @param couponUseRule  the coupon use rule
     * @param couponCodeMode the coupon code mode
     * @param stockSendRule  the stock send rule
     * @param outRequestNo   the out request no
     */
    FavorCreateParams(String stockName,
                      String belongMerchant,
                      String goodsName,
                      StockType stockType,
                      CouponUseRule couponUseRule,
                      CouponCodeMode couponCodeMode,
                      StockSendRule stockSendRule,
                      String outRequestNo) {
        this.stockName = stockName;
        this.belongMerchant = belongMerchant;
        this.goodsName = goodsName;
        this.stockType = stockType;
        this.couponUseRule = couponUseRule;
        this.couponCodeMode = couponCodeMode;
        this.stockSendRule = stockSendRule;
        this.outRequestNo = outRequestNo;
    }

    /**
     * Comment busi favor create params.
     *
     * @param comment the comment
     * @return the busi favor create params
     */
    public FavorCreateParams comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Custom entrance busi favor create params.
     *
     * @param customEntrance the custom entrance
     * @return the busi favor create params
     */
    public FavorCreateParams customEntrance(CustomEntrance customEntrance) {
        this.customEntrance = customEntrance;
        return this;
    }

    /**
     * Display pattern info busi favor create params.
     *
     * @param displayPatternInfo the display pattern info
     * @return the busi favor create params
     */
    public FavorCreateParams displayPatternInfo(DisplayPatternInfo displayPatternInfo) {
        this.displayPatternInfo = displayPatternInfo;
        return this;
    }

    /**
     * Notify config busi favor create params.
     *
     * @param notifyConfig the notify config
     * @return the busi favor create params
     */
    public FavorCreateParams notifyConfig(FavorNotifyConfig notifyConfig) {
        this.notifyConfig = notifyConfig;
        return this;
    }

    /**
     * Subsidy busi favor create params.
     *
     * @param subsidy the subsidy
     * @return the busi favor create params
     */
    public FavorCreateParams subsidy(Boolean subsidy) {
        this.subsidy = subsidy;
        return this;
    }

    /**
     * Mini programs appid favor create params.
     *
     * @param miniProgramsAppid the mini programs appid
     * @return the favor create params
     */
    public FavorCreateParams miniProgramsAppid(String miniProgramsAppid) {
        this.couponUseRule.miniProgramsAppid(miniProgramsAppid);
        return this;
    }

    /**
     * Mini programs path coupon use rule.
     *
     * @param miniProgramsPath the mini programs path
     * @return the coupon use rule
     */
    public FavorCreateParams miniProgramsPath(String miniProgramsPath) {
        this.couponUseRule.miniProgramsPath(miniProgramsPath);
        return this;
    }
}
