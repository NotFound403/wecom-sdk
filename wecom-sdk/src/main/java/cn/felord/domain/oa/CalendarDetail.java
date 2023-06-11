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

package cn.felord.domain.oa;

import cn.felord.enumeration.BoolEnum;
import lombok.Data;

import java.util.Set;

/**
 * @author felord
 * @since 2021/11/22 11:42
 */
@Data
public class CalendarDetail {
    private String calId;
    private String organizer;
    private BoolEnum readonly;
    private String summary;
    private String color;
    private String description;
    private BoolEnum isPublic;
    private PublicRange publicRange;
    private BoolEnum isCorpCalendar;
    private Set<CalendarSharer> shares;
}
