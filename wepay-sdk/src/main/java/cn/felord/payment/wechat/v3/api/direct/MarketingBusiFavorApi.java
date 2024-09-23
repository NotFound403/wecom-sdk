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
import cn.felord.payment.wechat.enumeration.CouponState;
import cn.felord.payment.wechat.v3.domain.GenericPayResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.AssociateTime;
import cn.felord.payment.wechat.v3.domain.busifavor.CodeUploadResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.CouponCodeUploadParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorAssociateInfo;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorBudgetParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorBudgetResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorCallbackSetting;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorCreateParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorDeactivateParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorRefundParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorReturnSubsidyResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorSubsidyListResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorSubsidyParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorSubsidyResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorSubsidyReturnParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorUpdateParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorUseParams;
import cn.felord.payment.wechat.v3.domain.busifavor.FavorUseResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.StockDetailResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.StockResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.UserCouponResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.UserCouponsDetailResponse;
import cn.felord.payment.wechat.v3.domain.busifavor.UserFavorQueryParams;
import cn.felord.retrofit.VoidResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.time.OffsetDateTime;


/**
 * 微信支付商家券
 *
 * @author dax
 * @since 2024/8/22
 */
public interface MarketingBusiFavorApi {
    /**
     * 创建商家券券批次API
     * <p>
     * 商家券介绍详见 <a target= "_blank" href= "https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter1_1.shtml">微信支付商家券</a>
     *
     * @param params the params
     * @return the wechat response entity
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/stocks")
    StockResponse createStock(@Body FavorCreateParams params) throws PayException;

    /**
     * 查询商家券批次详情API
     * <p>
     * 商户可通过该接口查询已创建的商家券批次详情信息。
     *
     * @param stockId the stock id
     * @return the wechat response entity
     * @throws PayException the pay exception
     */
    @GET("v3/marketing/busifavor/stocks/{stock_id}")
    StockDetailResponse queryStockDetail(@Path("stock_id") String stockId) throws PayException;

    /**
     * 核销用户券API
     * <p>
     * 在用户满足优惠门槛后，服务商可通过该接口核销用户微信卡包中具体某一张商家券。
     *
     * @param params the params
     * @return the wechat response entity
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/coupons/use")
    FavorUseResponse use(@Body FavorUseParams params) throws PayException;

    /**
     * 根据过滤条件查询用户券API
     * <p>
     * 商户自定义筛选条件（如创建商户号、归属商户号、发放商户号等），查询指定微信用户卡包中满足对应条件的所有商家券信息。
     *
     * @param openid the openid
     * @param params the params
     * @return the user coupon detail response
     * @throws PayException the pay exception
     */
    @GET("v3/marketing/busifavor/users/{openid}/coupons")
    UserCouponsDetailResponse queryUserStocks(@Path("openid") String openid, @QueryMap UserFavorQueryParams params) throws PayException;

    /**
     * 查询用户券详情API
     * <p>
     * 服务商可通过该接口查询微信用户卡包中某一张商家券的详情信息。
     *
     * @param openid     the openid
     * @param couponCode the coupon code
     * @param appid      the appid
     * @return the wechat response entity
     * @throws PayException the pay exception
     */
    @GET("v3/marketing/busifavor/users/{openid}/coupons/{coupon_code}/appids/{appid}")
    UserCouponResponse queryUserCoupon(@Path("openid") String openid,
                                       @Path("coupon_code") String couponCode,
                                       @Path("appid") String appid) throws PayException;

    /**
     * 上传预存code API
     * <p>
     * 商家券的Code码可由微信后台随机分配，同时支持商户自定义。
     * 如商家已有自己的优惠券系统，可直接使用自定义模式。
     * 即商家预先向微信支付上传券Code，当券在发放时，微信支付自动从已导入的Code中随机取值（不能指定），派发给用户。
     *
     * @param params the params
     * @return wechat response entity
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/stocks/{stock_id}/couponcodes")
    CodeUploadResponse uploadCouponCodes(@Body CouponCodeUploadParams params) throws PayException;

    /**
     * 设置商家券事件通知地址API
     * <p>
     * 用于设置接收商家券相关事件通知的URL，可接收商家券相关的事件通知、包括发放通知等。
     * 需要设置接收通知的URL，并在商户平台开通 <a target= "_blank" href= "https://pay.weixin.qq.com/index.php/xphp/cmkt_product/index#/pages/product/product?pid=3">营销事件推送</a> 的能力，即可接收到相关通知。
     * <p>
     * 营销事件推送：<a target= "_blank" href= "https://pay.weixin.qq.com/index.php/core/home/login?return_url=%2Findex.php%2Fxphp%2Fcmkt_product%2Findex#/pages/product/product?pid=3">点击开通产品权限</a>。由商家券批次创建方登录Pay平台，操作开通
     * <p>
     * 注意：
     * <ul>
     *     <li>仅可以收到由商户自己创建的批次相关的通知</li>
     *     <li>需要设置apiv3秘钥，否则无法收到回调。</li>
     *     <li>如果需要领券回调中的参数openid。需要创券时候传入 notify_appid参数。</li>
     * </ul>
     *
     * @param setting the setting
     * @return callbacks callbacks
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/callbacks")
    FavorCallbackSetting setCallbacks(@Body FavorCallbackSetting setting) throws PayException;

    /**
     * 获取商家券事件通知地址API
     * <p>
     * 通过调用此接口可查询设置的通知URL。
     * <p>
     * 注意：
     * <ul>
     *     <li>仅可以查询由请求商户号设置的商家券通知url</li>
     * </ul>
     *
     * @param mchId the mch id
     * @return callbacks callbacks
     * @throws PayException the pay exception
     */
    @GET("v3/marketing/busifavor/callbacks")
    FavorCallbackSetting getCallbacks(@Query("mchid") String mchId) throws PayException;

    /**
     * 查询调用方商家券事件通知地址API
     *
     * @return the callbacks
     * @throws PayException the pay exception
     */
    @GET("v3/marketing/busifavor/callbacks")
    FavorCallbackSetting getCallbacks() throws PayException;

    /**
     * 商家券关联订单信息API
     * <p>
     * 将有效态（未核销）的商家券与订单信息关联，用于后续参与摇奖以及返佣激励等操作的统计。
     * <p>
     * 注意：
     * 仅对有关联订单需求的券进行该操作
     *
     * @param associateInfo the associate info
     * @return the associate time
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/coupons/associate")
    AssociateTime associate(@Body FavorAssociateInfo associateInfo) throws PayException;

    /**
     * 商家券取消关联订单信息API
     * <p>
     * 取消商家券与订单信息的关联关系。
     * <p>
     * 注意：
     * 建议取消前调用查询接口，查到当前关联的商户单号并确认后，再进行取消操作
     *
     * @param associateInfo the associate info
     * @return the associate time
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/coupons/disassociate")
    AssociateTime disassociate(@Body FavorAssociateInfo associateInfo) throws PayException;

    /**
     * 修改批次预算API
     * <p>
     * 商户可以通过该接口修改批次单天发放上限数量或者批次最大发放数量
     *
     * @param stockId the stock id
     * @param params  the params
     * @return wechat response entity
     * @throws PayException the pay exception
     */
    @PATCH("v3/marketing/busifavor/stocks/{stock_id}/budget")
    FavorBudgetResponse budget(@Path("stock_id") String stockId, @Body FavorBudgetParams params) throws PayException;

    /**
     * 修改商家券基本信息API
     * <p>
     * 商户可以通过该接口修改商家券基本信息，已创建商家券批次，且修改时间位于有效期结束时间前
     *
     * @param stockId the stock id
     * @param params  the params
     * @return wechat response entity
     * @throws PayException the pay exception
     */
    @PATCH("v3/marketing/busifavor/stocks/{stock_id}")
    VoidResponse updateStock(@Path("stock_id") String stockId, @Body FavorUpdateParams params) throws PayException;

    /**
     * 申请退券API
     * <p>
     * 商户可以通过该接口为已核销的券申请退券
     *
     * @param params the params
     * @return wechat response entity
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/coupons/return")
    GenericPayResponse<OffsetDateTime> refund(@Body FavorRefundParams params) throws PayException;

    /**
     * 使券失效API
     * <p>
     * 前置条件：券的状态为{@link CouponState#SENDED}
     * <p>
     * 商户可以通过该接口将可用券进行失效处理，券被失效后无法再被核销
     *
     * @param params the params
     * @return wechat response entity
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/coupons/deactivate")
    GenericPayResponse<OffsetDateTime> deactivate(@Body FavorDeactivateParams params) throws PayException;

    /**
     * 营销补差回退API
     * <p>
     * 商户通过该接口可回退补差款
     *
     * @param params the params
     * @return wechat response entity
     * @throws PayException the pay exception
     */
    @POST("v3/marketing/busifavor/subsidy/return-receipts")
    FavorReturnSubsidyResponse returnReceipts(@Body FavorSubsidyReturnParams params) throws PayException;

    /**
     * 营销补差付款API
     * <p>
     * 该API主要用于商户营销补贴场景，
     * 支持基于单张券进行不同商户账户间的资金补差，
     * 从而提升财务结算、资金利用效率。<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/download/%E5%95%86%E5%AE%B6%E5%88%B8%E8%A1%A5%E5%B7%AE%E4%BA%A7%E5%93%81%E6%93%8D%E4%BD%9C%E6%96%87%E6%A1%A3.pdf">具体可参考操作文档</a>
     *
     * @param params the params
     * @return the wechat response entity
     * @throws PayException the pay exception
     * @since 1.0.13.RELEASE
     */
    @POST("v3/marketing/busifavor/subsidy/pay-receipts")
    FavorSubsidyListResponse payMakeup(@Body FavorSubsidyParams params) throws PayException;

    /**
     * 查询营销补差付款单详情API
     * <p>
     * 查询商家券营销补差付款单详情
     *
     * @param subsidyReceiptId the subsidyReceiptId
     * @return the wechat response entity
     * @throws PayException the pay exception
     * @since 1.0.13.RELEASE
     */
    @GET("v3/marketing/busifavor/subsidy/pay-receipts/{subsidy_receipt_id}")
    FavorSubsidyResponse queryMakeup(@Path("subsidy_receipt_id") String subsidyReceiptId) throws PayException;

}
