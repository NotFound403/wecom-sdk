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

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The type Update card.
 *
 * @author dax
 * @since 2023 /8/20
 */
@RequiredArgsConstructor
@Getter
public class UpdateCard {
    private final UpdateBaseInfo baseInfo;
    /**
     * 会员卡模版消息推荐类型，代表积分余额等变动消息赠券
     */
    private MsgOperation modifyMsgOperation;
    /**
     * 会员卡模版消息推荐类型，代表会员卡激活消息赠券
     */
    private MsgOperation activateMsgOperation;
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
     * 会员卡特权说明,限制1024汉字
     */
    private String prerogative;
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

    /**
     * 会员卡专用
     *
     * @param modifyMsgOperation the modify msg operation
     * @return the update card
     */
    public UpdateCard modifyMsgOperation(MsgOperation modifyMsgOperation) {
        this.modifyMsgOperation = modifyMsgOperation;
        return this;
    }

    /**
     * 会员卡专用
     *
     * @param activateMsgOperation the activate msg operation
     * @return the update card
     */
    public UpdateCard activateMsgOperation(MsgOperation activateMsgOperation) {
        this.activateMsgOperation = activateMsgOperation;
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
}
