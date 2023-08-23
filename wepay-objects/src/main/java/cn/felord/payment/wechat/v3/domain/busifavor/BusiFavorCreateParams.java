/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package cn.felord.payment.wechat.v3.domain.busifavor;

import cn.felord.payment.wechat.enumeration.CouponCodeMode;
import cn.felord.payment.wechat.enumeration.StockType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 创建商家券请求参数.
 *
 * @author felord.cn
 * @since 1.0.4.RELEASE
 */
@ToString
@RequiredArgsConstructor
@Getter
public class BusiFavorCreateParams {

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
    private BusiFavorNotifyConfig notifyConfig;
    /**
     * 是否允许营销补贴
     */
    private Boolean subsidy;

    /**
     * Comment busi favor create params.
     *
     * @param comment the comment
     * @return the busi favor create params
     */
    public BusiFavorCreateParams comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Custom entrance busi favor create params.
     *
     * @param customEntrance the custom entrance
     * @return the busi favor create params
     */
    public BusiFavorCreateParams customEntrance(CustomEntrance customEntrance) {
        this.customEntrance = customEntrance;
        return this;
    }

    /**
     * Display pattern info busi favor create params.
     *
     * @param displayPatternInfo the display pattern info
     * @return the busi favor create params
     */
    public BusiFavorCreateParams displayPatternInfo(DisplayPatternInfo displayPatternInfo) {
        this.displayPatternInfo = displayPatternInfo;
        return this;
    }

    /**
     * Notify config busi favor create params.
     *
     * @param notifyConfig the notify config
     * @return the busi favor create params
     */
    public BusiFavorCreateParams notifyConfig(BusiFavorNotifyConfig notifyConfig) {
        this.notifyConfig = notifyConfig;
        return this;
    }

    /**
     * Subsidy busi favor create params.
     *
     * @param subsidy the subsidy
     * @return the busi favor create params
     */
    public BusiFavorCreateParams subsidy(Boolean subsidy) {
        this.subsidy = subsidy;
        return this;
    }
}