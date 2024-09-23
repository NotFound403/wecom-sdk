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

import lombok.Data;

/**
 * The type Callee.
 *
 * @author dax
 * @since 2024/5/27
 */
@Data
public class Callee {
    /**
     * 被叫用户的通话时长，单位为分钟
     */
    private Integer duration;
    /**
     * 被叫用户的userid
     */
    private String userid;
    /**
     * 被叫用户的号码，当被叫用户为外部用户时返回
     */
    private String phone;
}
