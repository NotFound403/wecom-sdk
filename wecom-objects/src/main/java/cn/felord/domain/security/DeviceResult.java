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

import cn.felord.enumeration.DeviceImportStatus;
import lombok.Data;

/**
 * The type Device result.
 *
 * @author dax
 * @since 2024/10/10
 */
@Data
public class DeviceResult {
    /**
     * 导入设备记录的标识，对应请求中设备的顺序，从1开始
     */
    private Long deviceIndex;
    /**
     * 设备的唯一标识，仅导入成功的记录返回
     */
    private String deviceCode;
    /**
     * 当重复导入(status=2)时，与当前导入记录冲突的设备的device_code
     *
     * @since 1.2.8
     */
    private String duplicatedDeviceCode;
    /**
     * 导入结果
     */
    private DeviceImportStatus status;
}
