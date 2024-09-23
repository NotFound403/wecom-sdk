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

package cn.felord.domain.approval;

import lombok.Getter;
import lombok.ToString;

import java.time.Duration;

/**
 * 修改成员假期余额请求参数
 *
 * @author dax
 * @since 2024/8/14
 */
@ToString
@Getter
public class UserQuotaSettingRequest {
    private final String userid;
    private final Long vacationId;
    private final Duration leftduration;
    private final String remarks;

    /**
     * Instantiates a new User quota request.
     *
     * @param userid       the userid
     * @param vacationId   the vacation id
     * @param leftduration the leftduration
     */
    public UserQuotaSettingRequest(String userid, Long vacationId, Duration leftduration) {
        this(userid, vacationId, leftduration, null);
    }

    /**
     * Instantiates a new User quota request.
     *
     * @param userid       the userid
     * @param vacationId   the vacation id
     * @param leftduration the leftduration
     * @param remarks      the remarks
     */
    public UserQuotaSettingRequest(String userid, Long vacationId, Duration leftduration, String remarks) {
        this.userid = userid;
        this.vacationId = vacationId;
        this.leftduration = leftduration;
        this.remarks = remarks;
    }
}
