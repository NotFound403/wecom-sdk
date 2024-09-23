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
 * The type Uint 32 field.
 *
 * @author dax
 * @since 2024/8/3 18:23
 */
@Getter
public class Uint32Field extends FieldBase {
    private final Long valueUint32;

    /**
     * Instantiates a new Uint 32 field.
     *
     * @param fieldid     the fieldid
     * @param valueUint32 the value uint 32
     */
    public Uint32Field(Integer fieldid, Long valueUint32) {
        this(fieldid, null, valueUint32);
    }

    /**
     * Instantiates a new Uint 32 field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueUint32 the value uint 32
     */
    public Uint32Field(Integer fieldid, Integer subIdx, Long valueUint32) {
        super(fieldid, subIdx);
        this.valueUint32 = valueUint32;
    }
}
