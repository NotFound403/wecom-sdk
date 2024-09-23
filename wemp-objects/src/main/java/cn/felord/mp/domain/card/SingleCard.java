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
 * The type Single card.
 */
@ToString
@Getter
public class SingleCard {
    /**
     * 指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。
     * 填写true或false。默认false，注意填写该字段时，卡券须通过审核且库存不为0。
     */
    private Boolean isUniqueCode;
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
     * 指定领取者的openid，只有该用户能领取。
     * bind_openid字段为true的卡券必须填写，非指定openid不必填写。
     */
    private String openid;
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
     * Unique code single card.
     *
     * @param uniqueCode the unique code
     * @return the single card
     */
    public SingleCard uniqueCode(Boolean uniqueCode) {
        isUniqueCode = uniqueCode;
        return this;
    }

    /**
     * Code single card.
     *
     * @param code the code
     * @return the single card
     */
    public SingleCard code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Card id single card.
     *
     * @param cardId the card id
     * @return the single card
     */
    public SingleCard cardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    /**
     * Openid single card.
     *
     * @param openid the openid
     * @return the single card
     */
    public SingleCard openid(String openid) {
        this.openid = openid;
        return this;
    }

    /**
     * Outer str single card.
     *
     * @param outerStr the outer str
     * @return the single card
     */
    public SingleCard outerStr(String outerStr) {
        this.outerStr = outerStr;
        return this;
    }

    /**
     * Outer id single card.
     *
     * @param outerId the outer id
     * @return the single card
     */
    public SingleCard outerId(String outerId) {
        this.outerId = outerId;
        return this;
    }
}
