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
package cn.felord.payment.wechat.v3.domain.direct.basepay;


import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

/**
 * APP、Native支付请求参数.
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@RequiredArgsConstructor
public class AppNativePayRequest {

    /**
     * 通知URL必须为直接可访问的URL，不允许携带查询串。
     */
    private final String notifyUrl;
    /**
     * 商品描述
     * Image形象店-深圳腾大-QQ公仔
     */
    private final String description;
    /**
     * 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一，详见【商户订单号】。
     * 示例值：1217752501201407033233368018
     */
    private final String outTradeNo;
    /**
     * 支付金额
     */
    private final Amount amount;
    /**
     * 订单失效时间 rfc 3339 YYYY-MM-DDTHH:mm:ss+TIMEZONE
     */
    private OffsetDateTime timeExpire;
    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private String attach;
    /**
     * 订单优惠标记
     */
    private String goodsTag;
    /**
     * 优惠功能
     */
    private Detail detail;
    /**
     * 电子发票入口开放标识
     * <p>
     * 传入{@code true}时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效。
     *
     * @since 1.0.16.RELEASE
     */
    private Boolean supportFapiao;
    /**
     * 场景信息
     */
    private SceneInfo sceneInfo;
    /**
     * 结算信息
     */
    private SettleInfo settleInfo;

    /**
     * Time expire js pay request.
     *
     * @param timeExpire the time expire
     * @return the js pay request
     */
    public AppNativePayRequest timeExpire(OffsetDateTime timeExpire) {
        this.timeExpire = timeExpire;
        return this;
    }

    /**
     * Attach js pay request.
     *
     * @param attach the attach
     * @return the js pay request
     */
    public AppNativePayRequest attach(String attach) {
        this.attach = attach;
        return this;
    }

    /**
     * Goods tag js pay request.
     *
     * @param goodsTag the goods tag
     * @return the js pay request
     */
    public AppNativePayRequest goodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
        return this;
    }

    /**
     * Detail js pay request.
     *
     * @param detail the detail
     * @return the js pay request
     */
    public AppNativePayRequest detail(Detail detail) {
        this.detail = detail;
        return this;
    }

    /**
     * Support fapiao js pay request.
     *
     * @param supportFapiao the support fapiao
     * @return the js pay request
     */
    public AppNativePayRequest supportFapiao(boolean supportFapiao) {
        this.supportFapiao = supportFapiao;
        return this;
    }

    /**
     * Scene info js pay request.
     *
     * @param sceneInfo the scene info
     * @return the js pay request
     */
    public AppNativePayRequest sceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
        return this;
    }

    /**
     * Sets info.
     *
     * @param settleInfo the settle info
     * @return the info
     */
    public AppNativePayRequest settleInfo(SettleInfo settleInfo) {
        this.settleInfo = settleInfo;
        return this;
    }

    /**
     * To pay params pay params.
     *
     * @param appid the appid
     * @param mchid the mchid
     * @return the pay params
     */
    public PayParams toPayParams(String appid, String mchid) {
        return new PayParams(appid, mchid, notifyUrl, description,
                outTradeNo, amount, null, timeExpire, attach,
                goodsTag, detail, supportFapiao, sceneInfo, settleInfo);
    }
}
