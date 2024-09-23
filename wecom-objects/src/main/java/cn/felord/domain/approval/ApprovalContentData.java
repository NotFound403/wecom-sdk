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
import lombok.Getter;
import lombok.ToString;

/**
 * ApprovalContentData
 *
 * @param <V> the type parameter
 * @author dax
 * @since 2024/5/26
 */
@ToString
@Getter
public class ApprovalContentData<V extends ContentDataValue> {
    private final ApprovalCtrlType control;
    private final String id;
    private final V value;

    /**
     * Instantiates a new Approval content data.
     *
     * @param control the control
     * @param id      the id
     * @param value   the value
     */
    ApprovalContentData(ApprovalCtrlType control, String id, V value) {
        this.control = control;
        this.id = id;
        this.value = value;
    }
}
