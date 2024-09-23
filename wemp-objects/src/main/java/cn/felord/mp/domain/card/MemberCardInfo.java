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

import cn.felord.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 会员卡信息
 * <p>
 * 参见 <a href="https://mmbiz.qpic.cn/mmbiz/PiajxSqBRaEIQxibpLbyuSKibIIQhichBVsM74ZxRjzrH99AAFuo8MwNSxJDZNeFuMYC4h7ZM3IN34RjJNE8Wx4oAA/0?wx_fmt=png">...</a>
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@ToString
@Getter
@RequiredArgsConstructor
public class MemberCardInfo {
    /**
     * 商家自定义会员卡背景图，须先调用 上传图片接口 将背景图上传至CDN，否则报错，
     * 卡面设计请遵循 微信会员卡自定义背景设计规范 ,像素大小控制在 1000像素*600像素以下
     */
    private String backgroundPicUrl;
    /**
     * 基本的卡券数据
     */
    private final MemberCardBaseInfo baseInfo;
    /**
     * 会员卡特权说明,限制1024汉字
     */
    private final String prerogative;

    //  autoActivate activateUrl wxActivate 必须选择一个

    /**
     * 设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口
     */
    private Boolean autoActivate;
    /**
     * 激活会员卡的url
     */
    private String activateUrl;
    /**
     * 设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，
     * 否则设置wx_activate失效。填入该字段后仍需调用接口设置开卡项方可生效
     */
    private Boolean wxActivate;
    /**
     * 显示积分，填写true或false，如填写true，积分相关字段均为必填,若设置为true则后续不可以被关闭
     */
    private Boolean supplyBonus = false;
    /**
     * 设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段
     */
    private String bonusUrl;
    /**
     * 是否支持储值，填写true或false。如填写true，储值相关字段均为必填
     * 若设置为true则后续不可以被关闭。该字段须开通储值功能后方可使用， 详情见： 获取特殊权限
     */
    private Boolean supplyBalance = false;
    /**
     * 设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段
     */
    private String balanceUrl;
    /**
     * 自定义会员信息类目，会员卡激活后显示,包含name_type (name) 和url字段
     */
    private CustomField customField1;
    /**
     * 自定义会员信息类目，会员卡激活后显示，包含name_type(name)和url字段
     */
    private CustomField customField2;
    /**
     * 自定义会员信息类目，会员卡激活后显示，包含name_type (name) 和url字段
     */
    private CustomField customField3;
    /**
     * 积分清零规则
     */
    private String bonusCleared;
    /**
     * 积分规则
     */
    private String bonusRules;
    /**
     * 储值说明
     */
    private String balanceRules;
    /**
     * 激活会员卡url对应的小程序user_name，仅可跳转该公众号绑定的小程序
     */
    private String activateAppBrandUserName;
    /**
     * 激活会员卡url对应的小程序path
     */
    private String activateAppBrandPass;
    /**
     * 自定义会员信息类目，会员卡激活后显示
     */
    private CustomCell customCell1;
    /**
     * 积分规则
     */
    private BonusRule bonusRule;
    /**
     * 卡券高级信息
     */
    private AdvancedInfo advancedInfo;
    /**
     * 折扣，该会员卡享受的折扣优惠, (100-discount)%
     */
    private Integer discount;

    /**
     * Instantiates a new Member card info.
     *
     * @param backgroundPicUrl         the background pic url
     * @param baseInfo                 the base info
     * @param prerogative              the prerogative
     * @param autoActivate             the auto activate
     * @param wxActivate               the wx activate
     * @param supplyBonus              the supply bonus
     * @param bonusUrl                 the bonus url
     * @param supplyBalance            the supply balance
     * @param balanceUrl               the balance url
     * @param customField1             the custom field 1
     * @param customField2             the custom field 2
     * @param customField3             the custom field 3
     * @param bonusCleared             the bonus cleared
     * @param bonusRules               the bonus rules
     * @param balanceRules             the balance rules
     * @param activateUrl              the activate url
     * @param activateAppBrandUserName the activate app brand user name
     * @param activateAppBrandPass     the activate app brand pass
     * @param customCell1              the custom cell 1
     * @param bonusRule                the bonus rule
     * @param advancedInfo             the advanced info
     * @param discount                 the discount
     */
    @JsonCreator
    MemberCardInfo(@JsonProperty("background_pic_url") String backgroundPicUrl, @JsonProperty("base_info") MemberCardBaseInfo baseInfo,
                   @JsonProperty("prerogative") String prerogative, @JsonProperty("auto_activate") Boolean autoActivate,
                   @JsonProperty("wx_activate") Boolean wxActivate, @JsonProperty("supply_bonus") Boolean supplyBonus,
                   @JsonProperty("bonus_url") String bonusUrl, @JsonProperty("supply_balance") Boolean supplyBalance,
                   @JsonProperty("balance_url") String balanceUrl, @JsonProperty("custom_field1") CustomField customField1,
                   @JsonProperty("custom_field2") CustomField customField2, @JsonProperty("custom_field3") CustomField customField3,
                   @JsonProperty("bonus_cleared") String bonusCleared, @JsonProperty("bonus_rules") String bonusRules,
                   @JsonProperty("balance_rules") String balanceRules, @JsonProperty("activate_url") String activateUrl,
                   @JsonProperty("activate_app_brand_user_name") String activateAppBrandUserName, @JsonProperty("activate_app_brand_pass") String activateAppBrandPass,
                   @JsonProperty("custom_cell1") CustomCell customCell1, @JsonProperty("bonus_rule") BonusRule bonusRule,
                   @JsonProperty("advanced_info") AdvancedInfo advancedInfo, @JsonProperty("discount") Integer discount) {
        this.backgroundPicUrl = backgroundPicUrl;
        this.baseInfo = baseInfo;
        this.prerogative = prerogative;
        this.autoActivate = autoActivate;
        this.wxActivate = wxActivate;
        this.supplyBonus = supplyBonus;
        this.bonusUrl = bonusUrl;
        this.supplyBalance = supplyBalance;
        this.balanceUrl = balanceUrl;
        this.customField1 = customField1;
        this.customField2 = customField2;
        this.customField3 = customField3;
        this.bonusCleared = bonusCleared;
        this.bonusRules = bonusRules;
        this.balanceRules = balanceRules;
        this.activateUrl = activateUrl;
        this.activateAppBrandUserName = activateAppBrandUserName;
        this.activateAppBrandPass = activateAppBrandPass;
        this.customCell1 = customCell1;
        this.bonusRule = bonusRule;
        this.advancedInfo = advancedInfo;
        this.discount = discount;
    }

    /**
     * Background pic url member card info.
     *
     * @param backgroundPicUrl the background pic url
     * @return the member card info
     */
    public MemberCardInfo backgroundPicUrl(String backgroundPicUrl) {
        this.backgroundPicUrl = backgroundPicUrl;
        return this;
    }

    /**
     * Auto activate member card info.
     *
     * @param autoActivate the auto activate
     * @return the member card info
     */
    public MemberCardInfo autoActivate(boolean autoActivate) {
        this.autoActivate = autoActivate;
        return this;
    }

    /**
     * Wx activate member card info.
     *
     * @param wxActivate the wx activate
     * @return the member card info
     */
    public MemberCardInfo wxActivate(boolean wxActivate) {
        this.wxActivate = wxActivate;
        if (wxActivate) {
            this.activateUrl = null;
        }
        return this;
    }

    /**
     * Supply bonus member card info.
     *
     * @param bonusUrl     the bonus url
     * @param bonusRules   the bonus rules
     * @param bonusCleared the bonus cleared
     * @param bonusRule    the bonus rule
     * @return the member card info
     */
    public MemberCardInfo supplyBonus(String bonusUrl, String bonusRules, String bonusCleared, BonusRule bonusRule) {
        this.supplyBonus = true;
        this.bonusUrl = bonusUrl;
        this.bonusRules = bonusRules;
        this.bonusCleared = bonusCleared;
        this.bonusRule = bonusRule;
        return this;
    }

    /**
     * Supply balance member card info.
     *
     * @param balanceUrl   the balance url
     * @param balanceRules the balance rules
     * @return the member card info
     */
    public MemberCardInfo supplyBalance(String balanceUrl, String balanceRules) {
        this.supplyBalance = true;
        this.balanceUrl = balanceUrl;
        this.balanceRules = balanceRules;
        return this;
    }

    /**
     * Custom field 1 member card info.
     *
     * @param customField1 the custom field 1
     * @return the member card info
     */
    public MemberCardInfo customField1(CustomField customField1) {
        this.customField1 = customField1;
        return this;
    }

    /**
     * Custom field 2 member card info.
     *
     * @param customField2 the custom field 2
     * @return the member card info
     */
    public MemberCardInfo customField2(CustomField customField2) {
        this.customField2 = customField2;
        return this;
    }

    /**
     * Custom field 3 member card info.
     *
     * @param customField3 the custom field 3
     * @return the member card info
     */
    public MemberCardInfo customField3(CustomField customField3) {
        this.customField3 = customField3;
        return this;
    }

    /**
     * Activate url member card info.
     *
     * @param activateUrl the activate url
     * @return the member card info
     */
    public MemberCardInfo activateUrl(String activateUrl) {
        this.activateUrl = activateUrl;
        if (StringUtils.hasText(activateUrl)) {
            this.wxActivate = false;
        }
        return this;
    }

    /**
     * Activate app brand user name member card info.
     *
     * @param activateAppBrandUserName the activate app brand user name
     * @param activateAppBrandPass     the activate app brand pass
     * @return the member card info
     */
    public MemberCardInfo activateAppBrandUserName(String activateAppBrandUserName, String activateAppBrandPass) {
        this.activateAppBrandUserName = activateAppBrandUserName;
        this.activateAppBrandPass = activateAppBrandPass;
        return this;
    }

    /**
     * Custom cell 1 member card info.
     *
     * @param customCell1 the custom cell 1
     * @return the member card info
     */
    public MemberCardInfo customCell1(CustomCell customCell1) {
        this.customCell1 = customCell1;
        return this;
    }

    /**
     * Advanced info member card info.
     *
     * @param advancedInfo the advanced info
     * @return the member card info
     */
    public MemberCardInfo advancedInfo(AdvancedInfo advancedInfo) {
        this.advancedInfo = advancedInfo;
        return this;
    }

    /**
     * Discount member card info.
     *
     * @param discount the discount
     * @return the member card info
     */
    public MemberCardInfo discount(int discount) {
        this.discount = discount;
        return this;
    }
}
