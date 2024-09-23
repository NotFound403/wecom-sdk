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

package cn.felord.domain.agent;

import lombok.Data;

/**
 * @author dax
 * @since 2023/5/27 10:23
 */
@Data
public class AgentSettingRequest {
    /**
     * 企业应用详情
     */
    private String description;
    /**
     * 应用主页url
     */
    private String homeUrl;
    /**
     * 是否上报用户进入应用事件
     */
    private Integer isreportenter;
    /**
     * 企业应用头像的mediaid
     */
    private String logoMediaid;
    /**
     * 企业应用名称
     */
    private String name;
    /**
     * 企业应用可信域名
     */
    private String redirectDomain;
    /**
     * 企业应用是否打开地理位置上报
     */
    private Integer reportLocationFlag;
}
