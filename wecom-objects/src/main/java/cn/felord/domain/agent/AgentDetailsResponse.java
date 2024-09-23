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

import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.AgentCustomizedPubStatus;
import cn.felord.enumeration.BoolEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Agent details response.
 *
 * @author felord.cn
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AgentDetailsResponse extends WeComResponse {
    /**
     * 企业应用id
     */
    private String agentid;
    /**
     * 企业应用名称
     */
    private String name;
    /**
     * 企业应用方形头像
     */
    private String squareLogoUrl;
    /**
     * 企业应用详情
     */
    private String description;
    /**
     * 企业应用可见范围（人员），其中包括userid
     */
    private AllowUsers allowUserinfos;
    /**
     * 企业应用可见范围（部门）
     */
    private AllowParties allowPartys;
    /**
     * 企业应用可见范围（标签）
     */
    private AllowTags allowTags;
    /**
     * 企业应用是否被停用
     */
    private BoolEnum close;
    /**
     * 企业应用可信域名
     */
    private String redirectDomain;
    /**
     * 企业应用是否打开地理位置上报
     */
    private BoolEnum reportLocationFlag;
    /**
     * 是否上报用户进入应用事件
     */
    private BoolEnum isreportenter;
    /**
     * 应用主页url
     */
    private String homeUrl;
    /**
     * 代开发自建应用返回该字段，表示代开发发布状态
     */
    private AgentCustomizedPubStatus customizedPublishStatus;
}
