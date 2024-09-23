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
 * The type String field.
 *
 * @author dax
 * @since 2024/8/3 14:55
 */
@Getter
public class StringField extends FieldBase {
    private final String valueString;

    /**
     * Instantiates a new String field.
     *
     * @param fieldid     the fieldid
     * @param valueString the value string
     */
    public StringField(Integer fieldid, String valueString) {
        this(fieldid, null, valueString);
    }

    /**
     * Instantiates a new String field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueString the value string
     */
    public StringField(Integer fieldid, Integer subIdx, String valueString) {
        super(fieldid, subIdx);
        this.valueString = valueString;
    }
}
