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

package cn.felord.domain.hr;

import lombok.Getter;

/**
 * The type Uint 64 field.
 *
 * @author dax
 * @since 2024/8/3 18:23
 */
@Getter
public class Int64Field extends FieldBase {
    private final Long valueInt64;

    /**
     * Instantiates a new Int 64 field.
     *
     * @param fieldid    the fieldid
     * @param valueInt64 the value int 64
     */
    public Int64Field(Integer fieldid, Long valueInt64) {
        this(fieldid, null, valueInt64);
    }

    /**
     * Instantiates a new Int 64 field.
     *
     * @param fieldid    the fieldid
     * @param subIdx     the sub idx
     * @param valueInt64 the value int 64
     */
    public Int64Field(Integer fieldid, Integer subIdx, Long valueInt64) {
        super(fieldid, subIdx);
        this.valueInt64 = valueInt64;
    }
}
