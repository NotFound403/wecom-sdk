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

package cn.felord.payment.wechat.v3.api.direct;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.enumeration.PayType;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import cn.felord.payment.wechat.v3.domain.direct.basepay.AppPayResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.JsPayResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.PrepayResponse;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineAppPayRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineH5PayRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineJsPayRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineNativePayRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombinePayCloseParams;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombinePayCloseRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombinePayDetailResponse;
import cn.felord.payment.wechat.v3.retrofit.WechatPayRetrofitFactory;
import cn.felord.utils.AlternativeJdkIdGenerator;

import java.time.Instant;

/**
 * 普通支付-直连模式-合单支付.
 *
 * @author felord.cn
 * @since 2024/8/17 12:16
 */
public class CombinePayApi {
    private final AlternativeJdkIdGenerator idGenerator;
    private final InternalCombinePayApi internalCombinePayApi;
    private final AppMerchant appMerchant;

    /**
     * Instantiates a new Combine pay api.
     *
     * @param idGenerator the id generator
     * @param factory     the factory
     * @param appMerchant the app merchant
     */
    CombinePayApi(AlternativeJdkIdGenerator idGenerator, WechatPayRetrofitFactory factory, AppMerchant appMerchant) {
        this.idGenerator = idGenerator;
        this.internalCombinePayApi = factory.app(appMerchant).create(InternalCombinePayApi.class);
        this.appMerchant = appMerchant;
    }

    /**
     * APP下单API
     *
     * @param request the request
     * @return the app pay response
     * @throws PayException the pay exception
     */
    public AppPayResponse app(CombineAppPayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        PrepayResponse prepayResponse = internalCombinePayApi.prePay(PayType.APP.type(), request.toPayParams(appid, mchid));
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String nonceStr = idGenerator.generate32();
        String preId = prepayResponse.getPrepayId();
        String paySign = WechatPaySigner.sign(appMerchant, appid, timestamp, nonceStr, preId);
        return new AppPayResponse(appid, mchid, preId, "Sign=WXPay", nonceStr, timestamp, null, paySign);
    }

    /**
     * H5下单API
     *
     * @param request the request
     * @return the prepay response
     * @throws PayException the pay exception
     */
    public PrepayResponse h5(CombineH5PayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        return internalCombinePayApi.prePay(PayType.H5.type(), request.toPayParams(appid, mchid));
    }

    /**
     * JSAPI/小程序下单API
     *
     * @param request the request
     * @return the js pay response
     * @throws PayException the pay exception
     */
    public JsPayResponse jsapi(CombineJsPayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        PrepayResponse prepayResponse = internalCombinePayApi.prePay(PayType.JSAPI.type(), request.toPayParams(appid, mchid));
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String nonceStr = idGenerator.generate32();
        String packageStr = "prepay_id=" + prepayResponse.getPrepayId();
        String paySign = WechatPaySigner.sign(appMerchant, appid, timestamp, nonceStr, packageStr);
        return new JsPayResponse(appid, timestamp, nonceStr, packageStr, "RSA", paySign);
    }

    /**
     * Native下单API
     *
     * @param request the request
     * @return the prepay response
     * @throws PayException the pay exception
     */
    public PrepayResponse nativePay(CombineNativePayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        return internalCombinePayApi.prePay(PayType.NATIVE.type(), request.toPayParams(appid, mchid));
    }

    /**
     * 合单查询订单API
     *
     * @param combineOutTradeNo the combine out trade no
     * @return the combine pay detail response
     * @throws PayException the pay exception
     */
    public CombinePayDetailResponse queryTransactionByOutTradeNo(String combineOutTradeNo) throws PayException {
        return internalCombinePayApi.queryTransactionByOutTradeNo(combineOutTradeNo);
    }

    /**
     * 合单关闭订单API
     *
     * @param request the request
     * @return the boolean
     * @throws PayException the pay exception
     */
    public boolean close(CombinePayCloseRequest request) throws PayException {
        String combineOutTradeNo = request.getCombineOutTradeNo();
        CombinePayCloseParams payParams = request.toPayParams(appMerchant.getAppid());
        return internalCombinePayApi.close(combineOutTradeNo, payParams)
                .isSuccessful();
    }


}
