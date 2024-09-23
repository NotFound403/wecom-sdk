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
 * The type Card consume request.
 *
 * @author dax
 * @since 2024/8/18
 */
@ToString
@Getter
public class UserCardRequest extends UserCardInfo {

    /**
     * 是否校验code核销状态，填入true和false时的code异常状态返回数据不同。
     */
    private final boolean checkConsume;


    /**
     * Instantiates a new User card request.
     *
     * @param code         the code
     * @param checkConsume the check consume
     */
    public UserCardRequest(String code, boolean checkConsume) {
        super(code);
        this.checkConsume = checkConsume;
    }

    /**
     * Instantiates a new User card request.
     *
     * @param code         the code
     * @param checkConsume the check consume
     * @param cardId       the card id
     */
    public UserCardRequest(String code, boolean checkConsume, String cardId) {
        super(code, cardId);
        this.checkConsume = checkConsume;
    }
}
