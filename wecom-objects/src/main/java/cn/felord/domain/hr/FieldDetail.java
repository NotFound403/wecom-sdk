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

import cn.felord.enumeration.ValueResult;
import cn.felord.enumeration.ValueType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Field detail.
 *
 * @author dax
 * @since 2024/8/3 11:35
 */
@EqualsAndHashCode
@ToString
@Getter
public class FieldDetail {
    private final Integer fieldid;
    private final Integer subIdx;
    private final ValueResult result;
    private final ValueType valueType;
    private final String valueString;
    private final Long valueUint64;
    private final Long valueUint32;
    private final Long valueInt64;
    private final ValueMobile valueMobile;
    private final ValueFile valueFile;

    /**
     * Instantiates a new Field detail.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param result      the result
     * @param valueType   the value type
     * @param valueString the value string
     * @param valueUint64 the value uint 64
     * @param valueUint32 the value uint 32
     * @param valueInt64  the value int 64
     * @param valueMobile the value mobile
     * @param valueFile   the value file
     */
    public FieldDetail(@JsonProperty("fieldid") Integer fieldid,
                       @JsonProperty("sub_idx") Integer subIdx,
                       @JsonProperty("result") ValueResult result,
                       @JsonProperty("value_type") ValueType valueType,
                       @JsonProperty("value_string") String valueString,
                       @JsonProperty("value_uint64") Long valueUint64,
                       @JsonProperty("value_uint32") Long valueUint32,
                       @JsonProperty("value_int64") Long valueInt64,
                       @JsonProperty("value_mobile") ValueMobile valueMobile,
                       @JsonProperty("value_file") ValueFile valueFile) {
        this.fieldid = fieldid;
        this.subIdx = subIdx;
        this.result = result;
        this.valueType = valueType;
        this.valueString = valueString;
        this.valueUint64 = valueUint64;
        this.valueUint32 = valueUint32;
        this.valueInt64 = valueInt64;
        this.valueMobile = valueMobile;
        this.valueFile = valueFile;
    }
}
