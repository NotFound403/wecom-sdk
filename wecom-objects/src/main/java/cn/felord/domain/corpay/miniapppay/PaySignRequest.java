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

package cn.felord.domain.corpay.miniapppay;

import cn.felord.utils.AlternativeJdkIdGenerator;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/7/6 16:31
 */
@ToString
@Getter
public class PaySignRequest {
    private final String signType = "RSA";
    private final String appid;
    private final String nonce;
    private final String prepayId;
    private final Instant timestamp;

    /**
     * Instantiates a new Pay sign request.
     *
     * @param appid    the appid
     * @param prepayId the prepay id
     */
    public PaySignRequest(String appid, String prepayId) {
        this(appid, new AlternativeJdkIdGenerator().generate32(), prepayId, Instant.now());
    }

    /**
     * Instantiates a new Pay sign request.
     *
     * @param appid     the appid
     * @param nonce     the nonce
     * @param prepayId  the prepay id
     * @param timestamp the timestamp
     */
    public PaySignRequest(String appid, String nonce, String prepayId, Instant timestamp) {
        this.appid = appid;
        this.nonce = nonce;
        this.prepayId = prepayId;
        this.timestamp = timestamp;
    }
}
