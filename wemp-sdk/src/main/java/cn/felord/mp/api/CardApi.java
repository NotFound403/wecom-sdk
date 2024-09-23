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

package cn.felord.mp.api;

import cn.felord.mp.WeMpException;
import cn.felord.mp.domain.GenericMpResponse;
import cn.felord.mp.domain.MpResponse;
import cn.felord.mp.domain.card.AbandonCardCodeRequest;
import cn.felord.mp.domain.card.AbstractCard;
import cn.felord.mp.domain.card.BatchCardRequest;
import cn.felord.mp.domain.card.BatchCardResponse;
import cn.felord.mp.domain.card.CardBiz;
import cn.felord.mp.domain.card.CardBizRequest;
import cn.felord.mp.domain.card.CardDataList;
import cn.felord.mp.domain.card.CardId;
import cn.felord.mp.domain.card.CardInfoRequest;
import cn.felord.mp.domain.card.CardLandingRequest;
import cn.felord.mp.domain.card.CardLandingResponse;
import cn.felord.mp.domain.card.CardListResponse;
import cn.felord.mp.domain.card.CardPaySettingRequest;
import cn.felord.mp.domain.card.CardQrcodeRequest;
import cn.felord.mp.domain.card.CardQrcodeResponse;
import cn.felord.mp.domain.card.CardRequest;
import cn.felord.mp.domain.card.CardUpdateUserRequest;
import cn.felord.mp.domain.card.CardUpdateUserResponse;
import cn.felord.mp.domain.card.CardUserInfoResponse;
import cn.felord.mp.domain.card.DecryptCodeRequest;
import cn.felord.mp.domain.card.FreeCardBiz;
import cn.felord.mp.domain.card.MemberCard;
import cn.felord.mp.domain.card.MemberCardActivateForm;
import cn.felord.mp.domain.card.MemberCardActivateRequest;
import cn.felord.mp.domain.card.MemberCardBiz;
import cn.felord.mp.domain.card.MemberCardDetail;
import cn.felord.mp.domain.card.MemberCardDetailRequest;
import cn.felord.mp.domain.card.ModifyStockRequest;
import cn.felord.mp.domain.card.OpenUserCard;
import cn.felord.mp.domain.card.PayGiftRuleId;
import cn.felord.mp.domain.card.PayGiftRulesRequest;
import cn.felord.mp.domain.card.PayGiftRulesResponse;
import cn.felord.mp.domain.card.TestWhiteListRequest;
import cn.felord.mp.domain.card.UpdateCardRequest;
import cn.felord.mp.domain.card.UpdateCodeRequest;
import cn.felord.mp.domain.card.UserCardInfo;
import cn.felord.mp.domain.card.UserCardRequest;
import cn.felord.mp.domain.card.UserCardResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 微信卡券
 *
 * @author dax
 * @since 2024/8/18 11:41
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
     * @see MemberCard
     */
    @POST("card/create")
    GenericMpResponse<String> createCard(@Body CardRequest<AbstractCard> request) throws WeMpException;

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
    GenericMpResponse<AbstractCard> getCard(@Body CardId request) throws WeMpException;

    /**
     * 删除卡券接口
     * <p>
     * 删除卡券接口允许商户删除任意一类卡券。
     * 删除卡券后，该卡券对应已生成的领取用二维码、添加到卡包JS API均会失效。
     * <p>
     * 注意：如用户在商家删除卡券前已领取一张或多张该卡券依旧有效。
     * 即删除卡券不能删除已被用户领取，保存在微信客户端中的卡券。
     *
     * @param request the request
     * @return the mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/delete")
    MpResponse deleteCard(@Body CardId request) throws WeMpException;

    /**
     * 设置卡券失效接口
     * <p>
     * 为满足改票、退款等异常情况，可调用卡券失效接口将用户的卡券设置为失效状态。
     *
     * @param request the request
     * @return the mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/code/unavailable")
    MpResponse unavailableCardCode(@Body AbandonCardCodeRequest request) throws WeMpException;

    /**
     * 批量查询卡券列表
     *
     * @param request the request
     * @return the batch card response
     * @throws WeMpException the we mp exception
     */
    @POST("card/batchget")
    BatchCardResponse batchGetCard(@Body BatchCardRequest request) throws WeMpException;

    /**
     * 更改卡券信息接口
     * <p>
     * 支持更新所有卡券类型的部分通用字段及特殊卡券（会员卡、飞机票、电影票、会议门票）中特定字段的信息。
     *
     * @param request the request
     * @return the generic mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/update")
    GenericMpResponse<Boolean> updateCard(@Body UpdateCardRequest request) throws WeMpException;

    /**
     * 修改库存接口
     * <p>
     * 调用修改库存接口增减某张卡券的库存。
     *
     * @param request the request
     * @return the mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/modifystock")
    MpResponse modifyStock(@Body ModifyStockRequest request) throws WeMpException;

    /**
     * Activate member card mp response.
     *
     * @param request the request
     * @return the mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/membercard/activate")
    MpResponse activateMemberCard(@Body MemberCardActivateRequest request) throws WeMpException;

    /**
     * 设置开卡字段接口
     * <p>
     * 开发者在创建时填入wx_activate字段后，需要调用该接口设置用户激活时需要填写的选项，否则一键开卡设置不生效。
     * <p>
     * 参见 <a href="https://mmbiz.qpic.cn/mmbiz/PiajxSqBRaEIQxibpLbyuSK8ghZh6u55AiafY7UDDlAkOVnox1ABdGuKSeWhF78sF4nrtLjx2yLb85zmfIyseZ9eQ/0?wx_fmt=png">...</a>
     *
     * @param request the request
     * @return the activate form
     * @throws WeMpException the we mp exception UserCardInfo
     */
    @POST("card/membercard/activateuserform/set")
    MpResponse setActivateForm(@Body MemberCardActivateForm request) throws WeMpException;

    /**
     * 步骤五：拉取会员信息接口
     * <p>
     * 支持开发者根据CardID和Code查询会员信息。
     *
     * @param request the request
     * @return userinfo userinfo
     * @throws WeMpException the we mp exception
     */
    @POST("card/membercard/userinfo/get")
    CardUserInfoResponse getUserinfo(@Body UserCardInfo request) throws WeMpException;

    /**
     * 更新会员信息
     * <p>
     * 当会员持卡消费后，支持开发者调用该接口更新会员信息。
     * 会员卡交易后的每次信息变更需通过该接口通知微信，便于后续消息通知及其他扩展功能。
     *
     * @param request the request
     * @return the card landing response
     * @throws WeMpException the we mp exception
     */
    @POST("card/membercard/updateuser")
    CardUpdateUserResponse updateUser(@Body CardUpdateUserRequest request) throws WeMpException;

    /**
     * 更改Code接口
     * <p>
     * 为确保转赠后的安全性，微信允许自定义Code的商户对已下发的code进行更改。
     * <p>
     * 注：为避免用户疑惑，建议仅在发生转赠行为后（发生转赠后，微信会通过事件推送的方式告知商户被转赠的卡券Code）对用户的Code进行更改。
     *
     * @param request the request
     * @return the mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/code/update")
    MpResponse updateCode(@Body UpdateCodeRequest request) throws WeMpException;

    /**
     * 设置支付后投放卡券接口
     * <p>
     * 开通微信支付的商户可以设置在用户微信支付后自动为用户发送一条领卡消息，用户点击消息即可领取会员卡/优惠券。
     * 目前该功能仅支持微信支付商户号主体和制作会员卡公众号主体一致的情况下配置，否则报错。
     *
     * @param request the request
     * @return the mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/paygiftcard/add")
    PayGiftRulesResponse addPayGiftCard(@Body PayGiftRulesRequest request) throws WeMpException;

    /**
     * 删除支付后投放卡券规则接口
     * <p>
     * 删除之前已经设置的支付即会员规则。
     *
     * @param request the request
     * @return the mp response
     * @throws WeMpException the we mp exception
     */
    @POST("card/paygiftcard/delete")
    MpResponse deletePayGiftCard(@Body PayGiftRuleId request) throws WeMpException;


    /**
     * 拉取卡券概况数据接口
     * <p>
     * 支持调用该接口拉取本商户的总体数据情况，包括时间区间内的各指标总量。
     *
     * @param request the request
     * @return the card bizuin info
     * @throws WeMpException the we mp exception
     */
    @POST("datacube/getcardbizuininfo")
    CardDataList<CardBiz> getCardBizuinInfo(@Body CardBizRequest request) throws WeMpException;

    /**
     * 获取免费券数据接口
     * <p>
     * 支持开发者调用该接口拉取免费券（优惠券、团购券、折扣券、礼品券）在固定时间区间内的相关数据。
     *
     * @param request the request
     * @return the card card info
     * @throws WeMpException the we mp exception
     */
    @POST("datacube/getcardcardinfo")
    CardDataList<FreeCardBiz> getCardCardInfo(@Body CardInfoRequest request) throws WeMpException;

    /**
     * 拉取会员卡概况数据接口
     * <p>
     * 支持开发者调用该接口拉取公众平台创建的会员卡相关数据。
     *
     * @param request the request
     * @return the card member card info
     * @throws WeMpException the we mp exception
     */
    @POST("datacube/getcardmembercardinfo")
    CardDataList<MemberCardBiz> getCardMemberCardInfo(@Body CardBizRequest request) throws WeMpException;

    /**
     * 拉取单张会员卡数据接口
     * <p>
     * 支持开发者调用该接口拉取API创建的会员卡数据情况
     *
     * @param request the request
     * @return the card member card info
     * @throws WeMpException the we mp exception
     */
    @POST("datacube/getcardmembercarddetail")
    CardDataList<MemberCardDetail> getCardMemberCardInfo(@Body MemberCardDetailRequest request) throws WeMpException;

}
