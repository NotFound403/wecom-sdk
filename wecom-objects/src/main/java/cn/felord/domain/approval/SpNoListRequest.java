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

package cn.felord.domain.approval;

import cn.felord.domain.common.KV;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

/**
 * The type Sp no list request.
 *
 * @author dax
 * @since 2024/5/27 14:36
 */
@ToString
@Getter
public class SpNoListRequest {
    private final Instant starttime;
    private final Instant endtime;
    private final String newCursor;
    private final Integer size;
    private List<KV> filters;


    /**
     * Instantiates a new Sp no list request.
     *
     * @param starttime the starttime
     * @param endtime   the endtime
     * @param size      the size
     */
    public SpNoListRequest(Instant starttime, Instant endtime, int size) {
        this(starttime, endtime, size, "");
    }

    /**
     * Instantiates a new Sp no list request.
     *
     * @param starttime the starttime
     * @param endtime   the endtime
     * @param size      the size
     * @param newCursor the new cursor
     */
    public SpNoListRequest(Instant starttime, Instant endtime, int size, String newCursor) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.newCursor = newCursor;
        this.size = size;
    }

    public SpNoListRequest filters(List<KV> filters) {
        this.filters = filters;
        return this;
    }
}
