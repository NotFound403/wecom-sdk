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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.KfServiceState;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Kf session update request.
 *
 * @author dax
 * @since 2021 /9/30 14:09
 */
@ToString
@Getter
public class KfSessionUpdateRequest {
    private final String openKfid;
    private final String externalUserid;
    private final KfServiceState serviceState;
    private final String servicerUserid;

    /**
     * Instantiates a new Kf session update request.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param serviceState   the service state
     */
    public KfSessionUpdateRequest(String openKfid, String externalUserid, KfServiceState serviceState) {
        this(openKfid, externalUserid, serviceState, null);
    }

    /**
     * Instantiates a new Kf session update request.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param serviceState   the service state
     * @param servicerUserid the servicer userid
     */
    public KfSessionUpdateRequest(String openKfid, String externalUserid, KfServiceState serviceState, String servicerUserid) {
        this.openKfid = openKfid;
        this.externalUserid = externalUserid;
        this.serviceState = serviceState;
        this.servicerUserid = servicerUserid;
    }
}
