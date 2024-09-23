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
import lombok.ToString;

/**
 * The type Multiple card info.
 */
@ToString
@Getter
public class MultipleCardInfo {

    /**
     * 卡券Code码,
     * use_custom_code字段为true的卡券必须填写，
     * 非自定义code和导入code模式的卡券不必填写。
     */
    private String code;
    /**
     * 卡券ID
     */
    private String cardId;
    /**
     * outer_id字段升级版本，字符串类型，
     * 用户首次领卡时，会通过 领取事件推送 给商户；
     * 对于会员卡的二维码，用户每次扫码打开会员卡后点击任何url，会将该值拼入url中，方便开发者定位扫码来源
     */
    private String outerStr;
    /**
     * 领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。
     * 用户领取卡券后触发的 事件推送 中会带上此自定义场景值。
     */
    private String outerId;


    /**
     * Code multiple card info.
     *
     * @param code the code
     * @return the single card
     */
    public MultipleCardInfo code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Card id multiple card info.
     *
     * @param cardId the card id
     * @return the single card
     */
    public MultipleCardInfo cardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Outer str multiple card info.
     *
     * @param outerStr the outer str
     * @return the single card
     */
    public MultipleCardInfo outerStr(String outerStr) {
        this.outerStr = outerStr;
        return this;
    }

    /**
     * Outer id multiple card info.
     *
     * @param outerId the outer id
     * @return the single card
     */
    public MultipleCardInfo outerId(String outerId) {
        this.outerId = outerId;
        return this;
    }
}
