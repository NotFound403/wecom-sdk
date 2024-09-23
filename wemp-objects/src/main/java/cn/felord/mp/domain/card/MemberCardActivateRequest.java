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

import lombok.Data;

import java.time.Instant;

/**
 * 会员卡激活
 *
 * @author dax
 * @since 2024/8/18 16:15
 */
@Data
public class MemberCardActivateRequest {
    /**
     * 会员卡编号，由开发者填入，作为序列号显示在用户的卡包里。可与Code码保持等值。
     */
    private final String membershipNumber;
    /**
     * 领取会员卡用户获得的code
     */
    private String code;
    /**
     * 卡券ID,自定义code卡券必填
     */
    private String cardId;
    /**
     * 商家自定义会员卡背景图，须 先调用 上传图片接口 将背景图上传至CDN，否则报错，
     * 卡面设计请遵循 微信会员卡自定义背景设计规范
     */
    private String backgroundPicUrl;
    /**
     * 激活后的有效起始时间。若不填写默认以创建时的 data_info 为准。Unix时间戳格式。
     */
    private Instant activateBeginTime;
    /**
     * 激活后的有效截至时间。若不填写默认以创建时的 data_info 为准。Unix时间戳格式。
     */
    private Instant activateEndTime;
    /**
     * 初始积分，不填为0。
     */
    private Integer initBonus;
    /**
     * 积分同步说明。
     */
    private String initBonusRecord;
    /**
     * 初始余额，不填为0。
     */
    private Integer initBalance;
    /**
     * 创建时字段custom_field1定义类型的初始值，限制为4个汉字，12字节。
     */
    private String initCustomFieldValue1;
    /**
     * 创建时字段custom_field2定义类型的初始值，限制为4个汉字，12字节。
     */
    private String initCustomFieldValue2;
    /**
     * 创建时字段custom_field3定义类型的初始值，限制为4个汉字，12字节。
     */
    private String initCustomFieldValue3;
}
