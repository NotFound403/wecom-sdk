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

package cn.felord.mp.api;

import cn.felord.mp.WeMpException;
import cn.felord.mp.domain.GenericMpResponse;
import cn.felord.mp.domain.MpResponse;
import cn.felord.mp.domain.card.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 微信卡券
 *
 * @author dax
 * @since 2023 /8/18 11:41
 */
public interface CardApi {

    /**
     * 创建卡券
     * <p>
     * 创建卡券接口是微信卡券的基础接口，用于创建一类新的卡券，获取card_id，
     * 创建成功并通过审核后，商家可以通过文档提供的其他接口将卡券下发给用户，
     * 每次成功领取，库存数量相应扣除。
     *
     * @param request the request
     * @return the generic mp response
     * @throws WeMpException the we mp exception
     * @see CashCard
     * @see DiscountCard
     * @see GeneralCouponCard
     * @see GiftCard
     * @see GroupOnCard
     * @see MemberCard
     */
    @POST("card/create")
    GenericMpResponse<String> create(@Body CardRequest<AbstractCard> request) throws WeMpException;

    /**
     * 创建二维码接口
     * <p>
     * 开发者可调用该接口生成一张卡券二维码供用户扫码后添加卡券到卡包。
     *
     * @param request the request
     * @return the response body
     * @throws WeMpException the we mp exception
     */
    @POST("card/qrcode/create")
    CardQrcodeResponse createQrcode(@Body CardQrcodeRequest request) throws WeMpException;

    /**
     * 设置微信买单接口
     * <p>
     * 创建卡券之后，开发者可以通过该接口设置该card_id支持微信买单功能。
     * 值得开发者注意的是，设置买单的card_id必须已经配置了门店，否则会报错。
     *
     * @param request the request
     * @return the pay cell
     * @throws WeMpException the we mp exception
     */
    @POST("card/paycell/set")
    MpResponse setPayCell(@Body CardPaySettingRequest request) throws WeMpException;

    /**
     * 设置自助核销接口
     * <p>
     * 创建卡券之后，开发者可以通过设置微信买单接口设置该card_id支持自助核销功能。
     * 值得开发者注意的是，设置自助核销的card_id必须已经配置了门店，否则会报错。
     *
     * @param request the request
     * @return the self consume cell
     * @throws WeMpException the we mp exception
     */
    @POST("card/selfconsumecell/set")
    MpResponse setSelfConsumeCell(@Body CardPaySettingRequest request) throws WeMpException;

    /**
     * 设置测试白名单
     * <p>
     * 由于卡券有审核要求，为方便公众号调试，可以设置一些测试账号，这些账号可领取未通过审核的卡券，体验整个流程。
     *
     * @param request the request
     * @return the test whitelist
     * @throws WeMpException the we mp exception
     */
    @POST("card/testwhitelist/set")
    MpResponse setTestWhitelist(@Body TestWhiteListRequest request) throws WeMpException;

    /**
     * 创建货架接口
     * <p>
     * 开发者需调用该接口创建货架链接，用于卡券投放。创建货架时需填写投放路径的场景字段。
     *
     * @param request the request
     * @return the card landing response
     * @throws WeMpException the we mp exception
     */
    @POST("card/landingpage/create")
    CardLandingResponse landingpage(@Body CardLandingRequest request) throws WeMpException;

    /**
     * 查询Code接口，用于线下核销
     * <p>
     * 我们强烈建议开发者在调用核销code接口之前调用查询code接口，
     * 并在核销之前对非法状态的code(如转赠中、已删除、已核销等)做出处理。
     * <p>
     * 注意事项：
     * <ol>
     *     <li>固定时长有效期会根据用户实际领取时间转换，如用户2013年10月1日领取，固定时长有效期为90天，即有效时间为2013年10月1日-12月29日有效。</li>
     *     <li>无论check_consume填写的是true还是false,当code未被添加或者code被转赠领取是统一报错：invalid serial code</li>
     * </ol>
     *
     * @param request the request
     * @return the user card response
     * @throws WeMpException the we mp exception
     */
    @POST("card/code/get")
    UserCardResponse getUserCard(@Body UserCardRequest request) throws WeMpException;

    /**
     * 核销Code接口，用于线下核销
     * <p>
     * 消耗code接口是核销卡券的唯一接口,开发者可以调用当前接口将用户的优惠券进行核销，该过程不可逆
     * <p>
     * 注意事项：
     * <ol>
     *     <li>仅支持核销有效状态的卡券，若卡券处于异常状态，均不可核销。（异常状态包括：卡券删除、未生效、过期、转赠中、转赠退回、失效）</li>
     *     <li>自定义Code码（use_custom_code为true）的优惠券，在code被核销时，必须调用此接口。用于将用户客户端的code状态变更。自定义code的卡券调用接口时， post数据中需包含card_id，否则报invalid serial code，非自定义code不需上报。</li>
     * </ol>
     *
     * @param request the request
     * @return the user card response
     * @throws WeMpException the we mp exception
     */
    @POST("card/code/consume")
    UserCardResponse consumeUserCard(@Body UserCardInfo request) throws WeMpException;

    /**
     * Code解码接口
     * <p>
     * code解码接口支持两种场景：
     * <ol>
     *     <li>商家获取choos_card_info后，将card_id和encrypt_code字段通过解码接口，获取真实code。</li>
     *     <li>卡券内跳转外链的签名中会对code进行加密处理，通过调用解码接口获取真实code。</li>
     * </ol>
     *
     * @param request the request
     * @return the generic mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/code/decrypt")
    GenericMpResponse<String> decryptCode(@Body DecryptCodeRequest request) throws WeMpException;

    /**
     * 获取用户已领取卡券接口
     * <p>
     * 用于获取用户卡包里的，属于该appid下所有可用卡券，包括正常状态和异常状态。
     *
     * @param request the request
     * @return the card list
     * @throws WeMpException the we mp exception
     */
    @POST("card/user/getcardlist")
    CardListResponse getUserCardList(@Body OpenUserCard request) throws WeMpException;

    /**
     * 查看卡券详情
     * <p>
     * 开发者可以调用该接口查询某个card_id的创建信息、审核状态以及库存数量。
     *
     * @param request the request
     * @return the card
     * @throws WeMpException the we mp exception
     */
    @POST("card/get")
    CardListResponse getCard(@Body CardId request) throws WeMpException;

    /**
     * Update user card update user response.
     *
     * @param request the request
     * @return the card landing response
     * @throws WeMpException the we mp exception
     */
    @POST("card/membercard/updateuser")
    CardUpdateUserResponse updateUser(@Body CardUpdateUserRequest request) throws WeMpException;

}
