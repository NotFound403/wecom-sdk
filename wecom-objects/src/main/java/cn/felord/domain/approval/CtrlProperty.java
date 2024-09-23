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

import cn.felord.enumeration.ApprovalCtrlType;
import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * The type Ctrl property.
 *
 * @author dax
 * @since 2024/5/25 14:44
 */
@Data
public class CtrlProperty {
    private final ApprovalCtrlType control;
    private final String id;
    private final List<ApprovalTitle> title;
    private List<ApprovalTitle> placeholder;
    private BoolEnum require;
    private BoolEnum unPrint;

    /**
     * Instantiates a new Ctrl property.
     *
     * @param control the control
     * @param id      the id
     * @param title   the title
     */
    @JsonCreator
    CtrlProperty(@JsonProperty("control") ApprovalCtrlType control,
                 @JsonProperty("id") String id,
                 @JsonProperty("title") List<ApprovalTitle> title) {
        this.control = control;
        this.id = id;
        this.title = title;
    }

    /**
     * To data approval content data.
     *
     * @param <V>   the type parameter
     * @param value the value
     * @return the approval content data
     */
    <V extends ContentDataValue> ApprovalContentData<V> toData(V value) {
        return new ApprovalContentData<>(this.control, this.id, value);
    }
}
