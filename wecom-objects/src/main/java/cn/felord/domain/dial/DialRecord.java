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

package cn.felord.domain.dial;

import cn.felord.enumeration.CallType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * The type Dial record.
 */
@Data
public class DialRecord {
    /**
     * 主叫用户
     */
    private Caller caller;
    /**
     * 总通话时长，单位为分钟
     */
    private Integer totalDuration;
    /**
     * 被叫用户
     */
    private List<Callee> callee;
    /**
     * 拨出时间
     */
    private Instant callTime;
    /**
     * 通话类型
     */
    private CallType callType;
}
