/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.FormForkFinishType;
import cn.felord.enumeration.FormRepeatType;
import cn.felord.enumeration.FormWeekFlag;
import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/3/13 17:17
 */
@Data
public class TimedRepeatInfo {
    private Boolean enable;
    private Instant remindTime;
    private FormRepeatType repeatType;
    private FormWeekFlag weekFlag;
    private Boolean skipHoliday;
    private Integer dayOfMonth;
    private FormForkFinishType formForkFinishType;
}
