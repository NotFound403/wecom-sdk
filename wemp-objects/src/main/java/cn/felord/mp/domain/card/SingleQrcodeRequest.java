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

/**
 * 单张发送
 *
 * @author dax
 * @since 2024/8/18
 */
@Getter
public class SingleQrcodeRequest extends CardQrcodeRequest {
    private final SingleActionInfo actionInfo;
    /**
     * 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
     */
    private final Integer expireSeconds;

    /**
     * Instantiates a new Single qrcode request.
     *
     * @param actionInfo the action info
     */
    public SingleQrcodeRequest(SingleActionInfo actionInfo) {

        this(actionInfo, null);
    }

    /**
     * Instantiates a new Single qrcode request.
     *
     * @param actionInfo    the action info
     * @param expireSeconds the expire seconds
     */
    public SingleQrcodeRequest(SingleActionInfo actionInfo, Integer expireSeconds) {
        super("QR_CARD");
        this.actionInfo = actionInfo;
        this.expireSeconds = expireSeconds;
    }
}
