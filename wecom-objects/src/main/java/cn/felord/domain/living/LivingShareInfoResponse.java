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

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The LivingShareInfoResponse
 *
 * @author dax
 * @since 2024/11/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LivingShareInfoResponse extends WeComResponse {
    /**
     * 直播id
     */
    private String livingid;
    /**
     * 观众的userid，观众为企业内部成员时返回
     */
    private String viewerUserid;
    /**
     * 观众的external_userid，观众为非企业内部成员时返回
     */
    private String viewerExternalUserid;
    /**
     * 邀请人的userid，邀请人为企业内部成员时返回（观众首次进入直播时，其使用的直播卡片/二维码所对应的分享人）
     */
    private String invitorUserid;
    /**
     * 邀请人的external_userid，邀请人为非企业内部成员时返回 （观众首次进入直播时，其使用的直播卡片/二维码所对应的分享人）
     */
    private String invitorExternalUserid;
}
