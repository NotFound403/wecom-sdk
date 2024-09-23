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

package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import lombok.Getter;
import lombok.ToString;

/**
 * 更新为新的卡片
 *
 * @param <C> the type parameter
 * @author dax
 * @see TemplateReplaceCardBuilders
 * @since 2022 /2/7 10:55
 */
@ToString
@Getter
public class UpdateNewTemplateCardRequest<C extends AbstractReplaceCard> extends AbstractUpdateTemplateCardRequest {
    private final BoolEnum enableIdTrans;
    private final C templateCard;

    /**
     * Instantiates a new Update new template card request.
     *
     * @param agentid       the agentid
     * @param responseCode  the response code
     * @param enableIdTrans the enable id trans
     * @param templateCard  the template card
     */
    public UpdateNewTemplateCardRequest(String agentid, String responseCode, BoolEnum enableIdTrans, C templateCard) {
        super(agentid, responseCode);
        this.enableIdTrans = enableIdTrans;
        this.templateCard = templateCard;
    }
}
