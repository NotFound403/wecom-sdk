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
import cn.felord.payment.wechat.v3.domain.direct.basepay.*;
import cn.felord.payment.wechat.v3.retrofit.WechatPayRetrofitFactory;
import cn.felord.utils.AlternativeJdkIdGenerator;
import okhttp3.ResponseBody;

import java.time.Instant;

/**
 * 直连模式-基础支付
 *
 * @author dax
 * @since 2024/8/11
 */
public class DirectBasePayApi {
    private final AlternativeJdkIdGenerator idGenerator = new AlternativeJdkIdGenerator();
    private final WechatPayRetrofitFactory factory;
    private final InternalBasePayApi internalBasePayApi;
    private final AppMerchant appMerchant;

    /**
     * Instantiates a new Base pay api.
     *
     * @param factory     the factory
     * @param appMerchant the app merchant
     */
    public DirectBasePayApi(WechatPayRetrofitFactory factory, AppMerchant appMerchant) {
        this.factory = factory;
        this.internalBasePayApi = factory.app(appMerchant).create(InternalBasePayApi.class);
        this.appMerchant = appMerchant;
    }

    /**
     * JSAPI/小程序下单API
     *
     * @param request the request
     * @return the js pay response
     * @throws PayException the pay exception
     */
    public JsPayResponse jsapi(JsPayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        PrepayResponse prepayResponse = internalBasePayApi.prePay(PayType.JSAPI.type(), request.toPayParams(appid, mchid));
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String nonceStr = idGenerator.generate32();
        String packageStr = "prepay_id=" + prepayResponse.getPrepayId();
        String paySign = WechatPaySigner.sign(appMerchant, appid, timestamp, nonceStr, packageStr);
        return new JsPayResponse(appid, timestamp, nonceStr, packageStr, "RSA", paySign);
    }

    /**
     * APP下单API
     *
     * @param request the request
     * @return the app pay response
     * @throws PayException the pay exception
     */
    public AppPayResponse app(AppNativePayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        PrepayResponse prepayResponse = internalBasePayApi.prePay(PayType.APP.type(), request.toPayParams(appid, mchid));
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String nonceStr = idGenerator.generate32();
        String preId = prepayResponse.getPrepayId();
        String paySign = WechatPaySigner.sign(appMerchant, appid, timestamp, nonceStr, preId);
        return new AppPayResponse(appid, mchid,
                preId, "Sign=WXPay",
                nonceStr, timestamp,
                "RSA", paySign);
    }

    /**
     * Native下单API
     *
     * @param request the request
     * @return the prepay response
     * @throws PayException the pay exception
     */
    public PrepayResponse nativePay(AppNativePayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        return internalBasePayApi.prePay(PayType.NATIVE.type(), request.toPayParams(appid, mchid));
    }

    /**
     * H5下单API
     *
     * @param request the request
     * @return the prepay response
     * @throws PayException the pay exception
     */
    public PrepayResponse h5(H5PayRequest request) throws PayException {
        String mchid = appMerchant.merchantId();
        String appid = appMerchant.getAppid();
        return internalBasePayApi.prePay(PayType.H5.type(), request.toPayParams(appid, mchid));
    }

    /**
     * 微信支付订单号查询API
     *
     * @param transactionId the transaction id
     * @return the pay detail response
     * @throws PayException the pay exception
     */
    public PayDetailResponse queryTransactionById(String transactionId) throws PayException {
        return internalBasePayApi.queryTransactionById(transactionId, appMerchant.merchantId());
    }

    /**
     * 商户订单号查询API
     *
     * @param outTradeNo the out trade no
     * @return the pay detail response
     * @throws PayException the pay exception
     */
    public PayDetailResponse queryTransactionByOutTradeNo(String outTradeNo) throws PayException {
        return internalBasePayApi.queryTransactionByOutTradeNo(outTradeNo, appMerchant.merchantId());
    }

    /**
     * 关闭订单API
     *
     * @param outTradeNo the out trade no
     * @return the boolean
     * @throws PayException the pay exception
     */
    public boolean close(String outTradeNo) throws PayException {
        return internalBasePayApi.close(outTradeNo, new MchId(appMerchant.merchantId()))
                .isSuccessful();
    }

    /**
     * 申请退款API
     * <p>
     * 当交易发生之后一年内，由于买家或者卖家的原因需要退款时，
     * 卖家可以通过退款接口将支付金额退还给买家，
     * 微信支付将在收到退款请求并且验证成功之后，将支付款按原路退还至买家账号上。
     *
     * @param request the request
     * @return the refund response
     * @throws PayException the pay exception
     */
    public RefundResponse refund(RefundRequest request) throws PayException {
        return internalBasePayApi.refund(request);
    }

    /**
     * 查询单笔退款API
     *
     * @param outRefundNo the out refund no
     * @return the refund response
     * @throws PayException the pay exception
     */
    public RefundResponse queryRefundInfo(String outRefundNo) throws PayException {
        return internalBasePayApi.queryRefundInfo(outRefundNo);
    }

    /**
     * 申请交易账单API
     *
     * @param request the request
     * @return the bill url response
     * @throws PayException the pay exception
     */
    public BufferSource downloadTradeBill(TradeBillRequest request) throws PayException {
        BillUrlResponse billUrlResponse = internalBasePayApi.downloadTradeBill(
                request.getBillDate(),
                request.getBillType(),
                request.getTarType());
        try (ResponseBody body = internalBasePayApi.download(billUrlResponse.getDownloadUrl())) {
            return new BufferSource(body.contentType(), body.contentLength(), body.source());
        }
    }

    /**
     * 申请资金账单API
     *
     * @param request the request
     * @return the bill url response
     * @throws PayException the pay exception
     */
    public BufferSource downloadFundFlowBill(FundFlowBillRequest request) throws PayException {
        BillUrlResponse billUrlResponse = internalBasePayApi.downloadFundFlowBill(
                request.getBillDate(),
                request.getAccountType(),
                request.getTarType());
        try (ResponseBody body = internalBasePayApi.download(billUrlResponse.getDownloadUrl())) {
            return new BufferSource(body.contentType(), body.contentLength(), body.source());
        }
    }

    /**
     * 合单支付API
     *
     * @return the combine pay api
     */
    public CombinePayApi combinePay() {
        return new CombinePayApi(idGenerator, factory, appMerchant);
    }

}
