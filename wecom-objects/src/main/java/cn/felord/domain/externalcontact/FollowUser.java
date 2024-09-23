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

package cn.felord.domain.externalcontact;

import cn.felord.enumeration.AddWays;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/8 18:26
 */
@Data
public class FollowUser {
    private String userid;
    private String remark;
    private String description;
    private Instant createtime;
    private String remarkCorpName;
    private List<String> remarkMobiles;
    private WechatChannels wechatChannels;
    private String operUserid;
    private AddWays addWay;
    private String state;
    private List<ExternalContactTag> tags;
}
