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

package cn.felord.payment.wechat.v3.direct;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.enumeration.PayType;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import cn.felord.payment.wechat.v3.domain.basepay.AppPayParams;
import cn.felord.payment.wechat.v3.domain.basepay.PrepayResponse;
import cn.felord.payment.wechat.v3.domain.basepay.direct.AppPayResponse;
import cn.felord.payment.wechat.v3.domain.basepay.direct.JsPayResponse;
import cn.felord.payment.wechat.v3.domain.basepay.direct.PayRequest;
import cn.felord.payment.wechat.v3.retrofit.WechatPayRetrofitFactory;
import cn.felord.utils.AlternativeJdkIdGenerator;

import java.time.Instant;

/**
 * 直连模式-基础支付
 *
 * @author dax
 * @since 2023 /8/11
 */
public class DirectBasePayApi {
    private final AlternativeJdkIdGenerator idGenerator = new AlternativeJdkIdGenerator();
    private final WechatDirectPayApi wechatDirectPayApi;
    private final WechatPaySigner wechatPaySigner;
    private final String mchid;

    /**
     * Instantiates a new Base pay api.
     *
     * @param factory the factory
     * @param mchid   the mchid
     */
    public DirectBasePayApi(WechatPayRetrofitFactory factory, String mchid) {
        this.wechatDirectPayApi = factory.merchant(mchid).create(WechatDirectPayApi.class);
        this.wechatPaySigner = factory.wechatPaySigner();
        this.mchid = mchid;
    }

    /**
     * JSAPI/小程序下单API
     *
     * @param payParams the pay params
     * @return the js pay response
     * @throws PayException the pay exception
     */
    public JsPayResponse jsapi(AppPayParams payParams) throws PayException {
        PrepayResponse prepayResponse = wechatDirectPayApi.prePay(PayType.JSAPI.type(), new PayRequest(mchid, payParams));
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String nonceStr = idGenerator.generate32();
        String packageStr = "prepay_id=" + prepayResponse.getPrepayId();
        String appid = payParams.getAppid();
        String paySign = wechatPaySigner.sign(mchid, appid, timestamp, nonceStr, packageStr);
        return new JsPayResponse(appid, timestamp, nonceStr, packageStr, "RSA", paySign);
    }

    /**
     * APP下单API
     *
     * @param payParams the pay params
     * @return the app pay response
     * @throws PayException the pay exception
     */
    public AppPayResponse app(AppPayParams payParams) throws PayException {
        PrepayResponse prepayResponse = wechatDirectPayApi.prePay(PayType.APP.type(), new PayRequest(mchid, payParams));
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String nonceStr = idGenerator.generate32();
        String preId = prepayResponse.getPrepayId();
        String appid = payParams.getAppid();
        String paySign = wechatPaySigner.sign(mchid, appid, timestamp, nonceStr, preId);
        return new AppPayResponse(appid, mchid, preId, "Sign=WXPay", nonceStr, timestamp, "RSA", paySign);
    }

    /**
     * Native下单API
     *
     * @param payParams the pay params
     * @return the prepay response
     * @throws PayException the pay exception
     */
    public PrepayResponse nativePay(AppPayParams payParams) throws PayException {
        return wechatDirectPayApi.prePay(PayType.NATIVE.type(), new PayRequest(mchid, payParams));
    }

    /**
     * H5下单API
     *
     * @param payParams the pay params
     * @return the prepay response
     * @throws PayException the pay exception
     */
    public PrepayResponse h5(AppPayParams payParams) throws PayException {
        return wechatDirectPayApi.prePay(PayType.H5.type(), new PayRequest(mchid, payParams));
    }
}
