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

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * 普通支付统一参数
 *
 * @author felord.cn
 * @since 1.0.8.RELEASE
 */
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class PayParams {
    /**
     * 由微信生成的应用ID，全局唯一，框架注入
     */
    private final String appid;
    /**
     * 直连商户的商户号，由微信支付生成并下发，框架注入
     */
    private final String mchid;
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
     * 支付者  JSAPI/小程序下单 必传
     */
    private final Payer payer;
    /**
     * 订单失效时间 rfc 3339 YYYY-MM-DDTHH:mm:ss+TIMEZONE
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private final OffsetDateTime timeExpire;
    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private final String attach;
    /**
     * 订单优惠标记
     */
    private final String goodsTag;
    /**
     * 优惠功能
     */
    private final Detail detail;
    /**
     * 电子发票入口开放标识
     * <p>
     * 传入{@code true}时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效。
     *
     * @since 1.0.16.RELEASE
     */
    private final Boolean supportFapiao;
    /**
     * 场景信息
     */
    private final SceneInfo sceneInfo;
    /**
     * 结算信息
     */
    private final SettleInfo settleInfo;

}
