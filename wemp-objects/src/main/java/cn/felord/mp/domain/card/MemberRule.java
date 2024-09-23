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
 * 支付即会员结构体
 */
@ToString
@RequiredArgsConstructor
@Getter
public class MemberRule {
    /**
     * 要赠送的会员卡card_id
     */
    private final String cardId;
    /**
     * 单次消费送会员卡的金额下限 ，以分为单位
     */
    private final Long leastCost;
    /**
     * 单次消费送会员卡的金额上限 ，以分为单位
     */
    private final Long maxCost;
    /**
     * 商户自定义领卡网页链接，填入 后点击支付即会 员消息会跳转至商户网页领卡
     */
    private String jumpUrl;
    /**
     * 商户自定义领卡小程序appid，填入 后点击支付即会 员消息会跳转至商户小程序领卡
     */
    private String appBrandId;
    /**
     * 商户自定义领卡小程序路径，填入 后点击支付即会 员消息会跳转至商户小程序领卡
     */
    private String appBrandPass;

    /**
     * Jump url member rule.
     *
     * @param jumpUrl the jump url
     * @return the member rule
     */
    public MemberRule jumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
        return this;
    }

    /**
     * App brand member rule.
     *
     * @param appBrandId   the app brand id
     * @param appBrandPass the app brand pass
     * @return the member rule
     */
    public MemberRule appBrand(String appBrandId, String appBrandPass) {
        this.appBrandId = appBrandId;
        this.appBrandPass = appBrandPass;
        return this;
    }
}
