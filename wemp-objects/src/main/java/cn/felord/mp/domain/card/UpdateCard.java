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
import lombok.Getter;
import lombok.ToString;

/**
 * The type Update card.
 *
 * @author dax
 * @since 2024/8/20
 */
@ToString
@Getter
public class UpdateCard {
    private UpdateBaseInfo baseInfo;
    /**
     * 会员卡自定义卡面背景图
     */
    private String backgroundPicUrl;
    /**
     * 是否支持积分，仅支持从false变为true，默认为false
     */
    private Boolean supplyBonus;
    /**
     * 积分清零规则
     */
    private String bonusCleared;
    /**
     * 积分规则
     */
    private String bonusRules;
    /**
     * 积分信息类目跳转的url
     */
    private String bonusUrl;
    /**
     * 余额信息类目跳转的url
     */
    private String balanceUrl;
    /**
     * 是否支持储值，
     * 仅支持从false变为true，默认为fals e 该字段须开通储值功能后方可使用， 详情见： 获取特殊权限
     */
    private String supplyBalance;
    /**
     * 储值说明
     */
    private String balanceRules;
    /**
     * 会员卡特权说明,限制1024汉字
     */
    private String prerogative;
    /**
     * 是否开通一键开卡，
     * 设置为true时，该卡将支持一键开卡详情见 一键开卡 。 该选项与activate_url互斥。
     */
    private Boolean wxActivate;
    /**
     * 是否开通自动激活 ，
     * 设置为true时用户领取会员卡自动设置为激活， 详情见 自动激活 。
     */
    private Boolean autoActivate;
    /**
     * 激活链接，与wxActivate互斥
     */
    private String activateUrl;
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
     * 自定义会员信息类目，会员卡激活后显示
     */
    private CustomCell customCell1;
    private BonusRule bonusRule;


    public UpdateCard baseInfo(UpdateBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
        return this;
    }

    /**
     * Background pic url update card.
     *
     * @param backgroundPicUrl the background pic url
     * @return the update card
     */
    public UpdateCard backgroundPicUrl(String backgroundPicUrl) {
        this.backgroundPicUrl = backgroundPicUrl;
        return this;
    }

    /**
     * Supply bonus update card.
     *
     * @param supplyBonus the supply bonus
     * @return the update card
     */
    public UpdateCard supplyBonus(Boolean supplyBonus) {
        this.supplyBonus = supplyBonus;
        return this;
    }

    /**
     * Bonus cleared update card.
     *
     * @param bonusCleared the bonus cleared
     * @return the update card
     */
    public UpdateCard bonusCleared(String bonusCleared) {
        this.bonusCleared = bonusCleared;
        return this;
    }

    /**
     * Bonus rules update card.
     *
     * @param bonusRules the bonus rules
     * @return the update card
     */
    public UpdateCard bonusRules(String bonusRules) {
        this.bonusRules = bonusRules;
        return this;
    }

    /**
     * Bonus url update card.
     *
     * @param bonusUrl the bonus url
     * @return the update card
     */
    public UpdateCard bonusUrl(String bonusUrl) {
        this.bonusUrl = bonusUrl;
        return this;
    }

    /**
     * Balance url update card.
     *
     * @param balanceUrl the balance url
     * @return the update card
     */
    public UpdateCard balanceUrl(String balanceUrl) {
        this.balanceUrl = balanceUrl;
        return this;
    }

    /**
     * Supply balance update card.
     *
     * @param supplyBalance the supply balance
     * @return the update card
     */
    public UpdateCard supplyBalance(String supplyBalance) {
        this.supplyBalance = supplyBalance;
        return this;
    }

    /**
     * Balance rules update card.
     *
     * @param balanceRules the balance rules
     * @return the update card
     */
    public UpdateCard balanceRules(String balanceRules) {
        this.balanceRules = balanceRules;
        return this;
    }

    /**
     * Prerogative update card.
     *
     * @param prerogative the prerogative
     * @return the update card
     */
    public UpdateCard prerogative(String prerogative) {
        this.prerogative = prerogative;
        return this;
    }

    /**
     * Wx activate update card.
     *
     * @param wxActivate the wx activate
     * @return the update card
     */
    public UpdateCard wxActivate(Boolean wxActivate) {
        this.wxActivate = wxActivate;
        if (wxActivate) {
            this.activateUrl = null;
        }
        return this;
    }

    /**
     * Auto activate update card.
     *
     * @param autoActivate the auto activate
     * @return the update card
     */
    public UpdateCard autoActivate(Boolean autoActivate) {
        this.autoActivate = autoActivate;
        return this;
    }

    /**
     * Activate url update card.
     *
     * @param activateUrl the activate url
     * @return the update card
     */
    public UpdateCard activateUrl(String activateUrl) {
        this.activateUrl = activateUrl;
        if (StringUtils.hasText(activateUrl)) {
            this.wxActivate = false;
        }
        return this;
    }

    /**
     * Custom field 1 update card.
     *
     * @param customField1 the custom field 1
     * @return the update card
     */
    public UpdateCard customField1(CustomField customField1) {
        this.customField1 = customField1;
        return this;
    }

    /**
     * Custom field 2 update card.
     *
     * @param customField2 the custom field 2
     * @return the update card
     */
    public UpdateCard customField2(CustomField customField2) {
        this.customField2 = customField2;
        return this;
    }

    /**
     * Custom field 3 update card.
     *
     * @param customField3 the custom field 3
     * @return the update card
     */
    public UpdateCard customField3(CustomField customField3) {
        this.customField3 = customField3;
        return this;
    }

    /**
     * Custom cell 1 update card.
     *
     * @param customCell1 the custom cell 1
     * @return the update card
     */
    public UpdateCard customCell1(CustomCell customCell1) {
        this.customCell1 = customCell1;
        return this;
    }

    /**
     * Bonus rule update card.
     *
     * @param bonusRule the bonus rule
     * @return the update card
     */
    public UpdateCard bonusRule(BonusRule bonusRule) {
        this.bonusRule = bonusRule;
        return this;
    }
}
