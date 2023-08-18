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

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CardBgColor;
import cn.felord.mp.enumeration.CardCodeType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 基本的卡券数据
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@RequiredArgsConstructor
@Getter
public class MemberCardBaseInfo {
    /**
     * 卡券的商户logo，建议像素为300*300
     */
    private final String logoUrl;
    /**
     * 码型
     */
    private final CardCodeType codeType;
    /**
     * 卡券使用提醒，字数上限为16个汉字。
     */
    private final String notice;
    /**
     * 卡券使用说明，字数上限为1024个汉字。
     */
    private final String description;
    /**
     * 商户名字,字数上限为12个汉字
     */
    private final String brandName;
    /**
     * 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
     */
    private final String title;
    /**
     * 颜色
     */
    private final CardBgColor color;
    /**
     * 使用日期，有效期的信息
     */
    private final DateInfo dateInfo;
    /**
     * 支付功能结构体
     */
    private PayInfo payInfo;
    /**
     * 商品信息
     */
    private final Sku sku;
    /**
     * 是否设置该会员卡中部的按钮同时支持微信支付刷卡和会员卡二维码
     */
    private Boolean isPayAndQrcode;
    /**
     * 是否自定义Code码。填写true或false，
     * 默认为false 通常自有优惠码系统的开发者选择自定义Code码，详情见 是否自定义code
     */
    private Boolean useCustomCode;
    /**
     * 是否指定用户领取，填写true或false。默认为false
     */
    private Boolean bindOpenid;
    /**
     * 客服电话
     */
    private String servicePhone;
    /**
     * 门店位置ID。调用 POI门店管理接口 获取门店位置ID
     */
    private List<Integer> locationIdList;
    /**
     * 会员卡是否支持全部门店，填写后商户门店更新时会自动同步至卡券
     */
    private Boolean useAllLocations;
    /**
     * 卡券中部居中的按钮，仅在卡券激活后且可用状态 时显示
     */
    private String centerTitle;
    /**
     * 显示在入口下方的提示语 ， 仅在卡券激活后且可用状态时显示
     */
    private String centerSubTitle;
    /**
     * 顶部居中的url ，仅在卡券激活后且可用状态时显示
     */
    private String centerUrl;
    /**
     * 自定义跳转外链的入口名字
     */
    private String customUrlName;
    /**
     * 自定义跳转的URL
     */
    private String customUrl;
    /**
     * 显示在入口右侧的提示语
     */
    private String customUrlSubTitle;
    /**
     * 营销场景的自定义入口名称
     */
    private String promotionUrlName;
    /**
     * 营销入口跳转外链的地址链接
     */
    private String promotionUrl;
    /**
     * 显示在营销入口右侧的提示语
     */
    private String promotionUrlSubTitle;
    /**
     * 每人可领券的数量限制，建议会员卡每人限领一张
     */
    private Integer getLimit;
    /**
     * 卡券领取页面是否可分享，默认为true
     */
    private Boolean canShare;
    /**
     * 卡券是否可转赠,默认为true
     */
    private Boolean canGiveFriend;
    /**
     * 填写true为用户点击进入会员卡时推送事件，默认为false。详情见 进入会员卡事件推送
     */
    private Boolean needPushOnView;

    public MemberCardBaseInfo payInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
        return this;
    }

    public MemberCardBaseInfo payAndQrcode(Boolean payAndQrcode) {
        this.isPayAndQrcode = payAndQrcode;
        return this;
    }

    /**
     * Use custom code base info.
     *
     * @param useCustomCode the use custom code
     * @return the base info
     */
    public MemberCardBaseInfo useCustomCode(Boolean useCustomCode) {
        this.useCustomCode = useCustomCode;
        return this;
    }

    /**
     * Bind openid base info.
     *
     * @param bindOpenid the bind openid
     * @return the base info
     */
    public MemberCardBaseInfo bindOpenid(Boolean bindOpenid) {
        this.bindOpenid = bindOpenid;
        return this;
    }

    /**
     * Service phone base info.
     *
     * @param servicePhone the service phone
     * @return the base info
     */
    public MemberCardBaseInfo servicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
        return this;
    }

    /**
     * Location id list base info.
     *
     * @param locationIdList the location id list
     * @return the base info
     */
    public MemberCardBaseInfo locationIdList(List<Integer> locationIdList) {
        this.locationIdList = locationIdList;
        this.useAllLocations = false;
        return this;
    }

    /**
     * Use all locations base info.
     *
     * @param useAllLocations the use all locations
     * @return the base info
     */
    public MemberCardBaseInfo useAllLocations(Boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
        this.locationIdList = null;
        return this;
    }

    /**
     * Center base info.
     *
     * @param centerTitle    the center title
     * @param centerSubTitle the center sub title
     * @param centerUrl      the center url
     * @return the base info
     */
    public MemberCardBaseInfo centerBtn(String centerTitle, String centerSubTitle, String centerUrl) {
        this.centerTitle = centerTitle;
        this.centerSubTitle = centerSubTitle;
        this.centerUrl = centerUrl;
        return this;
    }

    /**
     * Custom url base info.
     *
     * @param customUrlName     the custom url name
     * @param customUrlSubTitle the custom url sub title
     * @param customUrl         the custom url
     * @return the base info
     */
    public MemberCardBaseInfo customUrl(String customUrlName, String customUrlSubTitle, String customUrl) {
        this.customUrlName = customUrlName;
        this.customUrlSubTitle = customUrlSubTitle;
        this.customUrl = customUrl;
        return this;
    }

    /**
     * Promotion url base info.
     *
     * @param promotionUrlName     the promotion url name
     * @param promotionUrlSubTitle the promotion url sub title
     * @param promotionUrl         the promotion url
     * @return the base info
     */
    public MemberCardBaseInfo promotionUrl(String promotionUrlName, String promotionUrlSubTitle, String promotionUrl) {
        this.promotionUrlName = promotionUrlName;
        this.promotionUrlSubTitle = promotionUrlSubTitle;
        this.promotionUrl = promotionUrl;
        return this;
    }


    /**
     * Gets limit.
     *
     * @param getLimit the get limit
     * @return the limit
     */
    public MemberCardBaseInfo getLimit(Integer getLimit) {
        this.getLimit = getLimit;
        return this;
    }

    /**
     * Can share base info.
     *
     * @param canShare the can share
     * @return the base info
     */
    public MemberCardBaseInfo canShare(Boolean canShare) {
        this.canShare = canShare;
        return this;
    }

    /**
     * Can give friend base info.
     *
     * @param canGiveFriend the can give friend
     * @return the base info
     */
    public MemberCardBaseInfo canGiveFriend(Boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
        return this;
    }

    /**
     * Need push on view base info.
     *
     * @param needPushOnView the need push on view
     * @return the base info
     */
    public MemberCardBaseInfo needPushOnView(Boolean needPushOnView) {
        this.needPushOnView = needPushOnView;
        return this;
    }

}