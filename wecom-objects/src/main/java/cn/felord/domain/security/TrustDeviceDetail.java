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

package cn.felord.domain.security;

import cn.felord.enumeration.DeviceSourceType;
import cn.felord.enumeration.DeviceStatus;
import cn.felord.enumeration.DeviceType;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * The type Trust device detail.
 *
 * @author dax
 * @since 2024/10/11
 */
@Data
public class TrustDeviceDetail {

    /**
     * 设备编码
     */
    private final String deviceCode;
    /**
     * 设备的类型，Windows或Mac
     */
    private final DeviceType system;
    /**
     * 设备MAC地址，当system为Windows时必填，Mac选填，每个设备最多100个
     */
    private final String macAddr;
    /**
     * Mac序列号，当system为Mac时必填
     */
    private final String seqNo;
    /**
     * 主板UUID，当system为Windows可选填此参数
     */
    private String motherboardUuid;
    /**
     * 硬盘序列号，当system为Windows时可选填此参数，每个设备最多100个
     */
    private Set<String> harddiskUuid;
    /**
     * Windows域名，当system为Windows时可选填此参数
     */
    private String domain;
    /**
     * Windows计算机名，当system为Windows时可选填此参数
     */
    private String pcName;
    /**
     * 设备最后登录时间戳
     */
    private Instant lastLoginTime;
    /**
     * 设备最后登录成员userid
     */
    private String lastLoginUserid;
    /**
     * 设备归属/确认时间戳
     */
    private Instant confirmTimestamp;
    /**
     * 设备归属/确认成员userid
     */
    private String confirmUserid;
    /**
     * 通过申报的管理员userid
     */
    private String approvedUserid;
    /**
     * 设备来源
     */
    private DeviceSourceType source;
    /**
     * 设备状态
     */
    private DeviceStatus status;
}
