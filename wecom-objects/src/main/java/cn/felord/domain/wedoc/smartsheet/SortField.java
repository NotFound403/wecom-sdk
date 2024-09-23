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

package cn.felord.domain.wedoc.smartsheet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Sort field.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class SortField {
    private final String fieldId;
    private final Boolean desc;

    /**
     * Instantiates a new Sort field.
     *
     * @param fieldId the field id
     * @param desc    the desc
     */
    @JsonCreator
    SortField(@JsonProperty("field_id") String fieldId, @JsonProperty("desc") Boolean desc) {
        this.fieldId = fieldId;
        this.desc = desc;
    }

    /**
     * Desc sort field.
     *
     * @param fieldId the field id
     * @return the sort field
     */
    public static SortField desc(String fieldId) {
        return new SortField(fieldId, true);
    }

    /**
     * Asc sort field.
     *
     * @param fieldId the field id
     * @return the sort field
     */
    public static SortField asc(String fieldId) {
        return new SortField(fieldId, false);
    }
}
