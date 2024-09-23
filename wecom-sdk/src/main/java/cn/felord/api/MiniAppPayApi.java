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

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.corpay.miniapppay.*;
import okhttp3.ResponseBody;
import retrofit2.http.*;

/**
 * 小程序接入对外收款
 * <p>
 * 本接口适用于在 由企业微信向微信发出的小程序中使用对外收款账户进行收款。
 *
 * @author dax
 * @since 2024/7/6 16:24
 */
public interface MiniAppPayApi {

    /**
     * 小程序下单
     * <p>
     * 商户系统先调用该接口通过企微后台生成预支付交易单，返回正确的预支付交易会话标识后再按小程序场景生成交易串调起支付。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("miniapppay/create_order")
    GenericResponse<String> createOrder(@Body MiniPayRequest request) throws WeComException;

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
     * @throws WeComException the weComException
     */
    @POST("miniapppay/get_order")
    PayOrderDetailResponse getOrder(@Body MchIdAndOutTradeNo request) throws WeComException;

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
     * @throws WeComException the weComException
     */
    @POST("miniapppay/close_order")
    WeComResponse closeOrder(@Body MchIdAndOutTradeNo request) throws WeComException;

    /**
     * 获取支付签名
     * <p>
     * 商户系统获取完预支付交易会话标识（prepay_id）后，在小程序端调用wxsdk前，需要调用本接口获取到必要的签名字段，再调起微信支付。
     *
     * @param request the request
     * @return the sign
     * @throws WeComException the weComException
     */
    @POST("miniapppay/get_sign")
    GenericResponse<String> getSign(@Body PaySignRequest request) throws WeComException;

    /**
     * 申请退款
     * <p>
     * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，企业微信将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家账户上。
     * <ol>
     *     <li>交易时间超过一年的订单无法提交退款。</li>
     *     <li>企业微信退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号。</li>
     *     <li>请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次，单笔订单请求频率限制：1qpm，即单笔订单每分钟申请退款请求次数不超过1次。</li>
     *     <li>每个支付订单的部分退款次数不能超过50次。</li>
     *     <li>申请退款接口的返回仅代表业务的受理情况，具体退款是否成功，需要通过退款查询接口获取结果。</li>
     * </ol>
     *
     * @param request the request
     * @return the refund response
     * @throws WeComException the weComException
     */
    @POST("miniapppay/refund")
    RefundResponse refund(@Body RefundRequest request) throws WeComException;

    /**
     * 查询退款
     * <p>
     * 退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
     *
     * @param request the request
     * @return the refund detail
     * @throws WeComException the weComException
     */
    @POST("miniapppay/get_refund_detail")
    RefundDetailResponse getRefundDetail(@Body MchIdAndOutRefundNo request) throws WeComException;

    /**
     * 交易账单申请
     * <p>
     * 按天提供交易账单文件，服务商可以通过该接口获取账单文件的下载地址。文件内包含交易相关的金额、时间、营销等信息，供商户核对订单、退款、银行到账等情况。
     *
     * @param request the request
     * @return the bill
     * @throws WeComException the weComException
     */
    @POST("miniapppay/get_bill")
    BillResponse getBill(@Body BillRequest request) throws WeComException;

    /**
     * 下载对账单
     * <p>
     * 文件说明
     * <p>
     * 交易账单文件内包含：明细数据表头、明细数据内容、汇总数据表头、汇总数据四个部分，每个字段使用英文逗号 , 间隔，明细数据内容每个字段前会增加1个字符 ` 用于避免获取的内容被excel展示为科学计数法的格式、丢失数据细节
     *
     * @param downloadUrl   the download url
     * @param authorization the authorization
     * @return the response body
     * @throws WeComException the weComException
     * @see #getBill(BillRequest) #getBill(BillRequest)交易账单申请
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/download/ALL.xlsx">对账单示例</a>
     */
    @GET
    ResponseBody downloadBill(@Url String downloadUrl, @Header("Authorization") String authorization) throws WeComException;

}
