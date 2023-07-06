package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.corpay.miniapppay.MiniPayRequest;
import cn.felord.domain.corpay.miniapppay.MchIdAndOutTradeNo;
import cn.felord.domain.corpay.miniapppay.PayOrderDetailResponse;
import cn.felord.domain.corpay.miniapppay.PaySignRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 小程序接入对外收款
 * <p>
 * 本接口适用于在 由企业微信向微信发出的小程序中使用对外收款账户进行收款。
 *
 * @author dax
 * @since 2023 /7/6 16:24
 */
public interface MiniAppPay {

    /**
     * 小程序下单
     * <p>
     * 商户系统先调用该接口通过企微后台生成预支付交易单，返回正确的预支付交易会话标识后再按小程序场景生成交易串调起支付。
     *
     * @param request the request
     * @return the generic response
     */
    @POST("miniapppay/create_order")
    GenericResponse<String> createOrder(@Body MiniPayRequest request);

    /**
     * 查询订单
     * <p>
     * 商户可以通过商户订单号查询订单，获取订单状态等信息，完成下一步的业务逻辑。
     * <p>
     * 需要调用查询接口的情况
     * <ul>
     *     <li>当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知。</li>
     *     <li>调用支付接口后，返回系统错误或未知交易状态情况。</li>
     *     <li> 调用关单或撤销接口API之前，需确认支付状态。</li>
     * </ul>
     *
     * @param request the request
     * @return the order
     */
    @POST("miniapppay/get_order")
    PayOrderDetailResponse getOrder(@Body MchIdAndOutTradeNo request);

    /**
     * 关闭订单
     * <p>
     * 订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
     * <p>
     * 以下情况需要调用关单接口
     * <ul>
     *     <li>商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付</li>
     *     <li>系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口</li>
     * </ul>
     *
     * @param request the request
     * @return the we com response
     */
    @POST("miniapppay/close_order")
    WeComResponse closeOrder(@Body MchIdAndOutTradeNo request);

    @POST("miniapppay/get_sign")
    GenericResponse<String> getSign(@Body PaySignRequest request);
}
