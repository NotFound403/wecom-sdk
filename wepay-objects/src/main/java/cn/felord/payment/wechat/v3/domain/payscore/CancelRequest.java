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

package cn.felord.payment.wechat.v3.domain.payscore;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Cancel request.
 */
@ToString
@Getter
public class CancelRequest {
    private final String appid;
    private final String reason;
    private final String serviceId;

    /**
     * Instantiates a new Cancel request.
     *
     * @param appid  the appid
     * @param reason the reason
     */
    public CancelRequest(String appid, String reason) {
        this(appid, reason, null);
    }

    /**
     * Instantiates a new Cancel request.
     *
     * @param appid     the appid
     * @param reason    the reason
     * @param serviceId the service id
     */
    public CancelRequest(String appid, String reason, String serviceId) {
        this.appid = appid;
        this.reason = reason;
        this.serviceId = serviceId;
    }
}
