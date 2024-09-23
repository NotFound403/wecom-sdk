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

import cn.felord.enumeration.CheckinExceptionType;
import lombok.Data;

@Data
public class ExceptionInfo {
    /**
     * 当日此异常的时长（迟到/早退/旷工才有值）
     */
    private Integer duration;
    /**
     * 校准状态类型：1-迟到；2-早退；3-缺卡；4-旷工；5-地点异常；6-设备异常
     */
    private CheckinExceptionType exception;
    /**
     * 当日此异常的次数
     */
    private Integer count;
}
