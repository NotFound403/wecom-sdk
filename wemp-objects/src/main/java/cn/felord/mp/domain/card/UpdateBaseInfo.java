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

package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.CardBgColor;
import cn.felord.mp.enumeration.CardCodeType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Update base info.
 *
 * @author dax
 * @since 2024/8/20
 */
@ToString
@Getter
public class UpdateBaseInfo {
    /**
     * 会员卡标题，字数上限为9个汉字
     */
    private String title;
    /**
     * 卡券的商户logo，建议像素为300*300
     */
    private String logoUrl;
    /**
     * 卡券使用提醒，字数上限为16个汉字。
     */
    private String notice;
    /**
     * 卡券使用说明，字数上限为1024个汉字。
     */
    private String description;
    /**
     * 客服电话
     */
    private String servicePhone;
    /**
     * 颜色
     */
    private CardBgColor color;
    /**
     * 门店位置ID。调用 POI门店管理接口 获取门店位置ID
     */
    private List<Integer> locationIdList;
    /**
     * 支持全部门店，填入后卡券门店跟随商户门店更新而更新
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
     * 码型
     */
    private CardCodeType codeType;
    /**
     * 支付功能结构体
     */
    private PayInfo payInfo;
    /**
     * 是否设置该会员卡中部的按钮同时支持微信支付刷卡和会员卡二维码
     */
    private PayInfo isPayAndQrcode;
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
     * 使用日期，有效期的信息
     */
    private DateInfo dateInfo;


    /**
     * Logo url update base info.
     *
     * @param logoUrl the logo url
     * @return the update base info
     */
    public UpdateBaseInfo logoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    /**
     * Notice update base info.
     *
     * @param notice the notice
     * @return the update base info
     */
    public UpdateBaseInfo notice(String notice) {
        this.notice = notice;
        return this;
    }

    /**
     * Description update base info.
     *
     * @param description the description
     * @return the update base info
     */
    public UpdateBaseInfo description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Service phone update base info.
     *
     * @param servicePhone the service phone
     * @return the update base info
     */
    public UpdateBaseInfo servicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
        return this;
    }

    /**
     * Color update base info.
     *
     * @param color the color
     * @return the update base info
     */
    public UpdateBaseInfo color(CardBgColor color) {
        this.color = color;
        return this;
    }

    /**
     * Center title update base info.
     *
     * @param centerTitle the center title
     * @return the update base info
     */
    public UpdateBaseInfo centerTitle(String centerTitle) {
        this.centerTitle = centerTitle;
        return this;
    }

    /**
     * Center sub title update base info.
     *
     * @param centerSubTitle the center sub title
     * @return the update base info
     */
    public UpdateBaseInfo centerSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
        return this;
    }

    /**
     * Center url update base info.
     *
     * @param centerUrl the center url
     * @return the update base info
     */
    public UpdateBaseInfo centerUrl(String centerUrl) {
        this.centerUrl = centerUrl;
        return this;
    }

    /**
     * Location id list update base info.
     *
     * @param locationIdList the location id list
     * @return the update base info
     */
    public UpdateBaseInfo locationIdList(List<Integer> locationIdList) {
        this.locationIdList = locationIdList;
        return this;
    }

    /**
     * Custom url name update base info.
     *
     * @param customUrlName the custom url name
     * @return the update base info
     */
    public UpdateBaseInfo customUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
        return this;
    }

    /**
     * Custom url update base info.
     *
     * @param customUrl the custom url
     * @return the update base info
     */
    public UpdateBaseInfo customUrl(String customUrl) {
        this.customUrl = customUrl;
        return this;
    }

    /**
     * Custom url sub title update base info.
     *
     * @param customUrlSubTitle the custom url sub title
     * @return the update base info
     */
    public UpdateBaseInfo customUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
        return this;
    }

    /**
     * Promotion url name update base info.
     *
     * @param promotionUrlName the promotion url name
     * @return the update base info
     */
    public UpdateBaseInfo promotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
        return this;
    }

    /**
     * Promotion url update base info.
     *
     * @param promotionUrl the promotion url
     * @return the update base info
     */
    public UpdateBaseInfo promotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
        return this;
    }

    /**
     * Promotion url sub title update base info.
     *
     * @param promotionUrlSubTitle the promotion url sub title
     * @return the update base info
     */
    public UpdateBaseInfo promotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
        return this;
    }

    /**
     * Code type update base info.
     *
     * @param codeType the code type
     * @return the update base info
     */
    public UpdateBaseInfo codeType(CardCodeType codeType) {
        this.codeType = codeType;
        return this;
    }

    /**
     * Gets limit.
     *
     * @param getLimit the get limit
     * @return the limit
     */
    public UpdateBaseInfo getLimit(Integer getLimit) {
        this.getLimit = getLimit;
        return this;
    }

    /**
     * Can share update base info.
     *
     * @param canShare the can share
     * @return the update base info
     */
    public UpdateBaseInfo canShare(Boolean canShare) {
        this.canShare = canShare;
        return this;
    }

    /**
     * Can give friend update base info.
     *
     * @param canGiveFriend the can give friend
     * @return the update base info
     */
    public UpdateBaseInfo canGiveFriend(Boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
        return this;
    }

    /**
     * Date info update base info.
     *
     * @param dateInfo the date info
     * @return the update base info
     */
    public UpdateBaseInfo dateInfo(DateInfo dateInfo) {
        this.dateInfo = dateInfo;
        return this;
    }

    /**
     * Title update base info.
     *
     * @param title the title
     * @return the update base info
     */
    public UpdateBaseInfo title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Use all locations update base info.
     *
     * @param useAllLocations the use all locations
     * @return the update base info
     */
    public UpdateBaseInfo useAllLocations(Boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
        return this;
    }

    /**
     * Pay info update base info.
     *
     * @param payInfo the pay info
     * @return the update base info
     */
    public UpdateBaseInfo payInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
        return this;
    }

    /**
     * Pay and qrcode update base info.
     *
     * @param isPayAndQrcode the is pay and qrcode
     * @return the update base info
     */
    public UpdateBaseInfo payAndQrcode(PayInfo isPayAndQrcode) {
        this.isPayAndQrcode = isPayAndQrcode;
        return this;
    }
}
