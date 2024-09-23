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
 * 多张发送
 *
 * @author dax
 * @since 2024/8/18
 */
@ToString
@Getter
public class MultipleQrcodeRequest extends CardQrcodeRequest {
    private final MultipleCard multipleCard;

    /**
     * Instantiates a new Multiple qrcode request.
     *
     * @param multipleCard the multiple card
     */
    public MultipleQrcodeRequest(MultipleCard multipleCard) {
        super("QR_MULTIPLE_CARD");
        this.multipleCard = multipleCard;
    }
}
