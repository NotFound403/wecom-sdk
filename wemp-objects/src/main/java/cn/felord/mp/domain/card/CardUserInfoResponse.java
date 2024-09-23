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

import cn.felord.mp.domain.MpResponse;
import cn.felord.mp.enumeration.UserCardStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CardUserInfoResponse extends MpResponse {
    /**
     * 用户在本公众号内唯一识别码
     */
    private String openid;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 积分信息
     */
    private Long bonus;
    /**
     * 余额信息
     */
    private Long balance;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 会员信息
     */
    private CardUserInfo userInfo;
    /**
     * 该卡是否已经被激活，true表示已经被激活，false表示未被激活
     */
    private Boolean hasActive;
    /**
     * 会员卡编号
     */
    private String membershipNumber;
    /**
     * 当前用户的会员卡状态，NORMAL 正常 EXPIRE
     * 已过期 GIFTING 转赠中 GIFT_SUCC 转赠成功
     * GIFT_TIMEOUT 转赠超时 DELETE 已删除，UNAVAILABLE 已失效
     */
    private UserCardStatus userCardStatus;
}
