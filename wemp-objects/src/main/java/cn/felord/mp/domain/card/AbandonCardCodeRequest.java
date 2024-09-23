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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 设置卡券失效
 *
 * @author dax
 * @since 2024/8/20
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class AbandonCardCodeRequest {
    private final String code;
    private final String cardId;
    private final String reason;

    /**
     * 非自定义卡券的请求
     *
     * @param code   the code
     * @param reason the reason
     * @return the abandon card code request
     */
    public static AbandonCardCodeRequest defaultCode(String code, String reason) {
        return new AbandonCardCodeRequest(code, null, reason);
    }

    /**
     * 自定义code卡券的请求
     *
     * @param code   the code
     * @param cardId the card id
     * @return the abandon card code request
     */
    public static AbandonCardCodeRequest customCode(String code, String cardId) {
        return new AbandonCardCodeRequest(code, cardId, null);
    }
}
