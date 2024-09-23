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

package cn.felord.mp.domain.card;

import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * The type Rule base info.
 */
@Data
public class RuleBaseInfo {
    /**
     * 商户号列表，是一个数组结构，建议单词 请求100个以下商户号
     */
    private final List<String> mchidList;
    /**
     * 规则开始时间
     */
    private final Instant endTime;
    /**
     * 规则结束时间
     */
    private final Instant beginTime;
}
