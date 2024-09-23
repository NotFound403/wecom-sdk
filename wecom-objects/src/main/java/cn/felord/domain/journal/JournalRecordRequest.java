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

package cn.felord.domain.journal;

import cn.felord.domain.common.KV;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
@ToString
@Getter
public class JournalRecordRequest {
    private final Instant starttime;
    private final Instant endtime;
    private final Integer cursor;
    private final Integer limit;
    private List<KV> filters;

    public JournalRecordRequest(Instant starttime, Instant endtime, Integer limit, int cursor) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.cursor = cursor;
        this.limit = limit;
    }

    public JournalRecordRequest filters(List<KV> filters) {
        this.filters = filters;
        return this;
    }
}
