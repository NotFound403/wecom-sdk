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
     * @return the response body
     * @throws WeMpException the we mp exception
     */
    @POST("card/create")
    CardResponse create(@Body CardRequest<AbstractCard> request) throws WeMpException;

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
     * Updateuser card landing response.
     *
     * @param request the request
     * @return the card landing response
     * @throws WeMpException the we mp exception
     */
    @POST("card/membercard/updateuser")
    CardUpdateUserResponse updateuser(@Body CardUpdateUserRequest request) throws WeMpException;

}
