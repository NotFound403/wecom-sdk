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

import cn.felord.mp.enumeration.CardType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 卡券
 * <ol>
 *     <li>会员卡类型对应 {@link MemberCard}</li>
 * </ol>
 *
 * @author dax
 * @since 2024/8/18 16:01
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "card_type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MemberCard.class, name = "MEMBER_CARD")
})
@ToString
@RequiredArgsConstructor
@Getter
public abstract class AbstractCard {
    private final CardType cardType;
}
