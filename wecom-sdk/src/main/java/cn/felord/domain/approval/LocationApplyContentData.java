/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/27
 */
public class LocationApplyContentData extends ApplyContentData<LocationValue> {
    @JsonCreator
    public LocationApplyContentData(@JsonProperty("control") ApprovalCtrlType control,
                                    @JsonProperty("id") String id,
                                    @JsonProperty("title") List<ApprovalTitle> title,
                                    @JsonProperty("value") LocationValue value,
                                    @JsonProperty("hidden") Integer hidden,
                                    @JsonProperty("require") BoolEnum require) {
        super(control, id, title, value, hidden, require);
    }
}
