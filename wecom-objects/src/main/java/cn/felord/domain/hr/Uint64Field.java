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
public class Uint64Field extends FieldBase {
    private final Long valueUint64;

    /**
     * Instantiates a new Uint 64 field.
     *
     * @param fieldid     the fieldid
     * @param valueUint64 the value uint 64
     */
    public Uint64Field(Integer fieldid, Long valueUint64) {
        this(fieldid, null, valueUint64);
    }

    /**
     * Instantiates a new Uint 64 field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueUint64 the value uint 64
     */
    public Uint64Field(Integer fieldid, Integer subIdx, Long valueUint64) {
        super(fieldid, subIdx);
        this.valueUint64 = valueUint64;
    }
}
