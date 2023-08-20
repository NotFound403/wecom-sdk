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
import lombok.ToString;

import java.util.List;

/**
 * @author dax
 * @since 2023/8/20
 */
@ToString
@Getter
public class UpdateBaseInfo {
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
     * 门店位置ID。调用 POI门店管理接口 获取门店位置ID
     */
    private List<Integer> locationIdList;
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


    public UpdateBaseInfo logoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public UpdateBaseInfo notice(String notice) {
        this.notice = notice;
        return this;
    }

    public UpdateBaseInfo description(String description) {
        this.description = description;
        return this;
    }

    public UpdateBaseInfo servicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
        return this;
    }

    public UpdateBaseInfo color(CardBgColor color) {
        this.color = color;
        return this;
    }

    public UpdateBaseInfo centerTitle(String centerTitle) {
        this.centerTitle = centerTitle;
        return this;
    }

    public UpdateBaseInfo centerSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
        return this;
    }

    public UpdateBaseInfo centerUrl(String centerUrl) {
        this.centerUrl = centerUrl;
        return this;
    }

    public UpdateBaseInfo locationIdList(List<Integer> locationIdList) {
        this.locationIdList = locationIdList;
        return this;
    }

    public UpdateBaseInfo customUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
        return this;
    }

    public UpdateBaseInfo customUrl(String customUrl) {
        this.customUrl = customUrl;
        return this;
    }

    public UpdateBaseInfo customUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
        return this;
    }

    public UpdateBaseInfo promotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
        return this;
    }

    public UpdateBaseInfo promotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
        return this;
    }

    public UpdateBaseInfo promotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
        return this;
    }

    public UpdateBaseInfo codeType(CardCodeType codeType) {
        this.codeType = codeType;
        return this;
    }

    public UpdateBaseInfo getLimit(Integer getLimit) {
        this.getLimit = getLimit;
        return this;
    }

    public UpdateBaseInfo canShare(Boolean canShare) {
        this.canShare = canShare;
        return this;
    }

    public UpdateBaseInfo canGiveFriend(Boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
        return this;
    }

    public UpdateBaseInfo dateInfo(DateInfo dateInfo) {
        this.dateInfo = dateInfo;
        return this;
    }
}
