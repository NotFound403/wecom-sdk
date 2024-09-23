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

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 更新会员信息
 *
 * @author dax
 * @since 2024/8/18 11:15
 */
@ToString
@RequiredArgsConstructor
@Getter
public class CardUpdateUserRequest {
    /**
     * 卡券Code码。
     */
    private final String code;
    /**
     * 卡券ID。
     */
    private final String cardId;
    /**
     * 支持商家激活时针对单个会员卡分配自定义的会员卡背景。
     */
    private String backgroundPicUrl;
    /**
     * 需要设置的积分全量值，传入的数值会直接显示
     */
    private Integer bonus;
    /**
     * 本次积分变动值，传负数代表减少
     */
    private Integer addBonus;
    /**
     * 商家自定义积分消耗记录，不超过14个汉字，购买焦糖玛 琪朵一杯，扣除金额30元。
     */
    private String recordBonus;
    /**
     * 需要设置的余额全量值，传入的数值会直接显示在卡面
     */
    private Integer balance;
    /**
     * 本次余额变动值，传负数代表减少
     */
    private Integer addBalance;
    /**
     * 商家自定义金额消耗记录，不超过14个汉字。
     */
    private String recordBalance;
    /**
     * 创建时字段custom_field1定义类型的最新数值，限制为4个汉字，12字节。白金
     */
    private String customFieldValue1;
    /**
     * 创建时字段custom_field2定义类型的最新数值，限制为4个汉字，12字节。8折
     */
    private String customFieldValue2;
    /**
     * 创建时字段custom_field3定义类型的最新数值，限制为4个汉字，12字节。500
     */
    private String customFieldValue3;
    /**
     * 控制原生消息结构体，包含各字段的消息控制字段
     */
    private NotifyOptional notifyOptional;


    /**
     * Background pic url card update user request.
     *
     * @param backgroundPicUrl the background pic url
     * @return the card update user request
     */
    public CardUpdateUserRequest backgroundPicUrl(String backgroundPicUrl) {
        this.backgroundPicUrl = backgroundPicUrl;
        return this;
    }

    /**
     * Bonus card update user request.
     *
     * @param bonus       the bonus
     * @param addBonus    the add bonus
     * @param recordBonus the record bonus
     * @return the card update user request
     */
    public CardUpdateUserRequest bonus(Integer bonus, Integer addBonus, String recordBonus) {
        this.bonus = bonus;
        this.addBonus = addBonus;
        this.recordBonus = recordBonus;
        return this;
    }

    /**
     * Balance card update user request.
     *
     * @param balance       the balance
     * @param addBalance    the add balance
     * @param recordBalance the record balance
     * @return the card update user request
     */
    public CardUpdateUserRequest balance(Integer balance, Integer addBalance, String recordBalance) {
        this.balance = balance;
        this.addBalance = addBalance;
        this.recordBalance = recordBalance;
        return this;
    }

    /**
     * Custom field value 1 card update user request.
     *
     * @param customFieldValue1 the custom field value 1
     * @return the card update user request
     */
    public CardUpdateUserRequest customFieldValue1(String customFieldValue1) {
        this.customFieldValue1 = customFieldValue1;
        return this;
    }

    /**
     * Custom field value 2 card update user request.
     *
     * @param customFieldValue2 the custom field value 2
     * @return the card update user request
     */
    public CardUpdateUserRequest customFieldValue2(String customFieldValue2) {
        this.customFieldValue2 = customFieldValue2;
        return this;
    }

    /**
     * Custom field value 3 card update user request.
     *
     * @param customFieldValue3 the custom field value 3
     * @return the card update user request
     */
    public CardUpdateUserRequest customFieldValue3(String customFieldValue3) {
        this.customFieldValue3 = customFieldValue3;
        return this;
    }

    /**
     * Notify optional card update user request.
     *
     * @param notifyOptional the notify optional
     * @return the card update user request
     */
    public CardUpdateUserRequest notifyOptional(NotifyOptional notifyOptional) {
        this.notifyOptional = notifyOptional;
        return this;
    }
}
