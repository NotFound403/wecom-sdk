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

package cn.felord.domain.checkin;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Clear checkin request.
 */
@ToString
@Getter
public class DelCheckinRequest {
    /**
     * 打卡规则id
     */
    private final Integer groupid;
    /**
     * 是否立即生效，默认false
     */
    private final Boolean effectiveNow;

    /**
     * Instantiates a new Clear checkin request.
     *
     * @param groupid the groupid
     */
    public DelCheckinRequest(Integer groupid) {
        this(groupid, false);
    }

    /**
     * Instantiates a new Clear checkin request.
     *
     * @param groupid      the groupid
     * @param effectiveNow the effective now
     */
    public DelCheckinRequest(Integer groupid, Boolean effectiveNow) {
        this.groupid = groupid;
        this.effectiveNow = effectiveNow;
    }
}
