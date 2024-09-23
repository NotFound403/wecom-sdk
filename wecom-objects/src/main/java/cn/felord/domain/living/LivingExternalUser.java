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

package cn.felord.domain.living;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.ContactUserType;
import lombok.Data;

import java.time.Duration;

/**
 * @author dax
 * @since 2023/5/24 11:36
 */
@Data
public class LivingExternalUser {

    /**
     * 外部成员的userid
     */
    private String externalUserid;
    /**
     * 外部成员类型
     */
    private ContactUserType type;
    /**
     * 外部成员的名称
     */
    private String name;
    /**
     * 观看时长，单位为秒
     */
    private Duration watchTime;
    /**
     * 是否评论
     */
    private BoolEnum isComment;
    /**
     * 是否连麦发言
     */
    private BoolEnum isMic;
    /**
     * 邀请人的userid，邀请人为企业内部成员时返回（观众首次进入直播时，其使用的直播卡片/二维码所对应的分享人；仅“推广产品”直播支持）
     */
    private String invitorUserid;
    /**
     * 邀请人的external_userid，邀请人为非企业内部成员时返回（观众首次进入直播时，其使用的直播卡片/二维码所对应的分享人；仅“推广产品”直播支持）
     */
    private String invitorExternalUserid;
}
