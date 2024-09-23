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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 关联控件
 *
 * @author dax
 * @since 2024/10/12
 */
@ToString
@Getter
public class Relation {
    /**
     * 关联控件的控件ID
     */
    private final String relatedControlId;
    /**
     * 固定为1
     */
    private final Integer action;

    /**
     * Instantiates a new Op relation.
     *
     * @param relatedControlId the related control id
     * @param action           the action
     */
    @JsonCreator
    public Relation(@JsonProperty("related_control_id") String relatedControlId,
                    @JsonProperty("action") Integer action) {
        this.relatedControlId = relatedControlId;
        this.action = action;
    }
}
