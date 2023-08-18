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

import lombok.Data;

/**
 * 会员卡信息
 * <p>
 * <img src="https://mmbiz.qpic.cn/mmbiz/PiajxSqBRaEIQxibpLbyuSKibIIQhichBVsM74ZxRjzrH99AAFuo8MwNSxJDZNeFuMYC4h7ZM3IN34RjJNE8Wx4oAA/0?wx_fmt=png"/>
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
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
    /**
     * 设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口
     */
    private Boolean autoActivate;
    /**
     * 设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，
     * 否则设置wx_activate失效。填入该字段后仍需调用接口设置开卡项方可生效
     */
    private Boolean wxActivate;
    /**
     * 显示积分，填写true或false，如填写true，积分相关字段均为必填,若设置为true则后续不可以被关闭
     */
    private final Boolean supplyBonus;
    /**
     * 设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段
     */
    private String bonusUrl;
    /**
     * 是否支持储值，填写true或false。如填写true，储值相关字段均为必填
     * 若设置为true则后续不可以被关闭。该字段须开通储值功能后方可使用， 详情见： 获取特殊权限
     */
    private final Boolean supplyBalance;
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
     * 激活会员卡的url
     */
    private String activateUrl;
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
}