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

import java.time.Instant;
import java.util.Set;

/**
 * The type Checkin data request.
 */
@ToString
@Getter
public class DeviceCheckinQueryRequest {
    private final Integer filterType;
    private final Instant starttime;
    private final Instant endtime;
    private final Set<String> useridlist;

    /**
     * Instantiates a new Device checkin query request.
     *
     * @param filterType the filter type
     * @param starttime  the starttime
     * @param endtime    the endtime
     * @param useridlist the useridlist
     */
    DeviceCheckinQueryRequest(int filterType, Instant starttime, Instant endtime, Set<String> useridlist) {
        this.filterType = filterType;
        this.starttime = starttime;
        this.endtime = endtime;
        this.useridlist = useridlist;
    }

    /**
     * 按打卡时间过滤
     *
     * @param starttime  the starttime
     * @param endtime    the endtime
     * @param useridlist the useridlist
     * @return the device checkin query request
     */
    public static DeviceCheckinQueryRequest filterByCheckinTime(Instant starttime, Instant endtime, Set<String> useridlist) {
        return new DeviceCheckinQueryRequest(1, starttime, endtime, useridlist);
    }

    /**
     * 按设备上传打卡记录的时间过滤
     *
     * @param starttime  the starttime
     * @param endtime    the endtime
     * @param useridlist the useridlist
     * @return the device checkin query request
     */
    public static DeviceCheckinQueryRequest filterByRecordTime(Instant starttime, Instant endtime, Set<String> useridlist) {
        return new DeviceCheckinQueryRequest(2, starttime, endtime, useridlist);
    }
}
