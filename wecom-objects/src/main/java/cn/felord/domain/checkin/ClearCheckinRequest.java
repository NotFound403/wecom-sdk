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

import cn.felord.enumeration.CheckinClearType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Clear checkin request.
 */
@ToString
@Getter
public class ClearCheckinRequest {
    /**
     * 打卡规则id
     */
    private final Integer groupid;
    /**
     * 清空的字段标识
     */
    private final List<CheckinClearType> clearField;
    /**
     * 是否立即生效，默认false
     */
    private final Boolean effectiveNow;

    /**
     * Instantiates a new Clear checkin request.
     *
     * @param groupid    the groupid
     * @param clearField the clear field
     */
    public ClearCheckinRequest(Integer groupid, List<CheckinClearType> clearField) {
        this(groupid, clearField, false);
    }

    /**
     * Instantiates a new Clear checkin request.
     *
     * @param groupid      the groupid
     * @param clearField   the clear field
     * @param effectiveNow the effective now
     */
    public ClearCheckinRequest(Integer groupid, List<CheckinClearType> clearField, Boolean effectiveNow) {
        this.groupid = groupid;
        this.clearField = clearField;
        this.effectiveNow = effectiveNow;
    }
}
