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
import lombok.Data;

import java.time.Duration;

/**
 * @author dax
 * @since 2023/5/24 11:36
 */
@Data
public class LivingUser {

    /**
     * 企业成员的userid
     */
    private String userid;
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
    private Integer isMic;
    /**
     * 邀请人的userid
     */
    private String invitorUserid;
    /**
     * 邀请人的external_userid
     */
    private String invitorExternalUserid;
}
