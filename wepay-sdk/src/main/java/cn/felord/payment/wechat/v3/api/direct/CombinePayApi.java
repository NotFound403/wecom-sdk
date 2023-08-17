package cn.felord.payment.wechat.v3.api.direct;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.enumeration.PayType;
import cn.felord.payment.wechat.v3.crypto.AppMerchant;
import cn.felord.payment.wechat.v3.crypto.WechatPaySigner;
import cn.felord.payment.wechat.v3.domain.direct.basepay.*;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineAppPayRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineH5PayRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineJsPayRequest;
import cn.felord.payment.wechat.v3.domain.direct.basepay.combine.CombineNativePayRequest;
import cn.felord.payment.wechat.v3.retrofit.WechatPayRetrofitFactory;
import cn.felord.utils.AlternativeJdkIdGenerator;

import java.time.Instant;

/**
 * 普通支付-直连模式-合单支付.
 *
 * @author felord.cn
 * @since 2023/8/17 12:16
 */
public class CombinePayApi {
    private final AlternativeJdkIdGenerator idGenerator;
    private final InternalCombinePayApi internalCombinePayApi;
    private final AppMerchant appMerchant;

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
}
