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
 * The type Mobile field.
 *
 * @author dax
 * @since 2024/8/3 14:55
 */
@Getter
public class MobileField extends FieldBase {
    private final ValueMobile valueMobile;

    /**
     * Instantiates a new Mobile field.
     *
     * @param fieldid     the fieldid
     * @param valueMobile the value mobile
     */
    public MobileField(Integer fieldid, ValueMobile valueMobile) {
        this(fieldid, null, valueMobile);
    }

    /**
     * Instantiates a new Mobile field.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param valueMobile the value mobile
     */
    public MobileField(Integer fieldid, Integer subIdx, ValueMobile valueMobile) {
        super(fieldid, subIdx);
        this.valueMobile = valueMobile;
    }
}
