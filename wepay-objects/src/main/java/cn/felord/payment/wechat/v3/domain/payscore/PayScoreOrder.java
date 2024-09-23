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
package cn.felord.payment.wechat.v3.domain.payscore;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 创建支付分订单请求参数.
 *
 * @author felord.cn
 * @since 1.0.2.RELEASE
 */
@ToString
@RequiredArgsConstructor
@Getter
public class PayScoreOrder {

    /**
     * 商户服务订单号，必填
     * <p>
     * 商户系统内部服务订单号（不是交易单号），要求此参数只能由数字、大小写字母_-|*组成，且在同一个商户号下唯一。详见[商户订单号]。
     */
    private final String outOrderNo;
    /**
     * 与传入的商户号建立了支付绑定关系的appid，必填
     */
    private final String appid;
    /**
     * 服务ID，必填
     * <p>
     * 该服务ID有本接口对应产品的权限。
     */
    private final String serviceId;
    /**
     * 服务信息，必填
     * <p>
     * 用于介绍本订单所提供的服务 ，当参数长度超过20个字符时，报错处理。
     */
    private String serviceIntroduction;
    /**
     * 后付费项目，选填
     */
    private List<PostPayment> postPayments;
    /**
     * 后付费商户优惠，选填
     */
    private List<PostDiscount> postDiscounts;
    /**
     * 服务时间段，必填
     */
    private final TimeRange timeRange;
    /**
     * 服务位置，选填
     */
    private Location location;
    /**
     * 订单风险金，必填
     */
    private final RiskFund riskFund;
    /**
     * 商户数据包，选填
     * <p>
     * 商户数据包可存放本订单所需信息，需要先urlencode后传入。 当商户数据包总长度超出256字符时，报错处理。
     */
    private String attach;
    /**
     * 商户回调地址，必填
     */
    private final String notifyUrl;
    /**
     * 微信用户在商户对应appid下的唯一标识，条件选填
     * <p>
     * 免确认订单：必填
     * 需确认订单：不填
     */
    private String openid;
    /**
     * 是否需要用户确认，选填
     * <p>
     * false：免确认订单
     * true：需确认订单
     * 默认值true
     */
    private final Boolean needUserConfirm;


    /**
     * Instantiates a new Pay score order.
     *
     * @param outOrderNo          the out order no
     * @param appid               the appid
     * @param serviceId           the service id
     * @param serviceIntroduction the service introduction
     * @param postPayments        the post payments
     * @param postDiscounts       the post discounts
     * @param timeRange           the time range
     * @param location            the location
     * @param riskFund            the risk fund
     * @param attach              the attach
     * @param notifyUrl           the notify url
     * @param openid              the openid
     * @param needUserConfirm     the need user confirm
     */
    @JsonCreator
    PayScoreOrder(@JsonProperty("out_order_no") String outOrderNo,
                  @JsonProperty("appid") String appid,
                  @JsonProperty("service_id") String serviceId,
                  @JsonProperty("service_introduction") String serviceIntroduction,
                  @JsonProperty("postPayments") List<PostPayment> postPayments,
                  @JsonProperty("post_discounts") List<PostDiscount> postDiscounts,
                  @JsonProperty("time_range") TimeRange timeRange,
                  @JsonProperty("location") Location location,
                  @JsonProperty("risk_fund") RiskFund riskFund,
                  @JsonProperty("attach") String attach,
                  @JsonProperty("notify_url") String notifyUrl,
                  @JsonProperty("openid") String openid,
                  @JsonProperty("need_user_confirm") Boolean needUserConfirm) {
        this.outOrderNo = outOrderNo;
        this.appid = appid;
        this.serviceId = serviceId;
        this.serviceIntroduction = serviceIntroduction;
        this.postPayments = postPayments;
        this.postDiscounts = postDiscounts;
        this.timeRange = timeRange;
        this.location = location;
        this.riskFund = riskFund;
        this.attach = attach;
        this.notifyUrl = notifyUrl;
        this.openid = openid;
        this.needUserConfirm = needUserConfirm;
    }

    /**
     * Service introduction pay score order.
     *
     * @param serviceIntroduction the service introduction
     * @return the pay score order
     */
    public PayScoreOrder serviceIntroduction(String serviceIntroduction) {
        this.serviceIntroduction = serviceIntroduction;
        return this;
    }

    /**
     * Post payments pay score order.
     *
     * @param postPayments the post payments
     * @return the pay score order
     */
    public PayScoreOrder postPayments(List<PostPayment> postPayments) {
        this.postPayments = postPayments;
        return this;
    }

    /**
     * Post discounts pay score order.
     *
     * @param postDiscounts the post discounts
     * @return the pay score order
     */
    public PayScoreOrder postDiscounts(List<PostDiscount> postDiscounts) {
        this.postDiscounts = postDiscounts;
        return this;
    }

    /**
     * Location pay score order.
     *
     * @param location the location
     * @return the pay score order
     */
    public PayScoreOrder location(Location location) {
        this.location = location;
        return this;
    }

    /**
     * Attach pay score order.
     *
     * @param attach the attach
     * @return the pay score order
     */
    public PayScoreOrder attach(String attach) {
        this.attach = attach;
        return this;
    }

    /**
     * Openid pay score order.
     *
     * @param openid the openid
     * @return the pay score order
     */
    public PayScoreOrder openid(String openid) {
        this.openid = openid;
        return this;
    }
}
