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

import cn.felord.enumeration.SecurityDeviceType;
import lombok.Data;

import java.time.Instant;

/**
 * The type File opt record detail.
 *
 * @author dax
 * @since 2024/10/9
 */
@Data
public class FileOptRecordDetail {
    /**
     * 操作时间
     */
    private Instant time;
    /**
     * 操作信息
     */
    private Operation operation;
    /**
     * 文件操作说明
     */
    private String fileInfo;
    /**
     * 企业用户账号id，当操作者为企业内部用户时返回该字段
     */
    private String userid;
    /**
     * 企业外部人员账号信息，当操作者为企业外部用户时返回该结构
     */
    private ExternalUser externalUser;
    /**
     * 当记录操作类型为『通过下载申请』或者『拒绝下载申请』时，该字段表示申请人的名字
     */
    private String applicantName;
    /**
     * 设备类型。仅当操作类型为『下载』时会返回
     */
    private SecurityDeviceType deviceType;
    /**
     * 设备编码。仅当操作类型为『下载』时会返回
     */
    private String deviceCode;
}
