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

import lombok.*;

/**
 * 修改卡券请求参数
 *
 * @author dax
 * @since 2024/8/19
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
@Getter
public class UpdateCardRequest {
    private final String cardId;
    private UpdateCard memberCard;

    /**
     * 修改会员卡
     *
     * @param cardId     the card id
     * @param updateCard the update card
     * @return the update card request
     */
    public static UpdateCardRequest memberCard(String cardId, UpdateCard updateCard) {
        UpdateCardRequest updateCardRequest = new UpdateCardRequest(cardId);
        updateCardRequest.setMemberCard(updateCard);
        return updateCardRequest;
    }

}
