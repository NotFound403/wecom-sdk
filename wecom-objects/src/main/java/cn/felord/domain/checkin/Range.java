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

import lombok.Data;

import java.util.List;

@Data
public class Range {
    /**
     * 打卡人员中，单个打卡人员节点的userid
     */
    private List<String> tagid;
    /**
     * 打卡人员中，部门节点的id
     */
    private List<String> partyId;
    /**
     * 打卡人员中，标签节点的标签id
     */
    private List<String> userid;
}
