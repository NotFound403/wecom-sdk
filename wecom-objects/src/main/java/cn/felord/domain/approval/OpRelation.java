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

import java.util.List;

/**
 * 关联控件
 *
 * @author dax
 * @since 2024/10/12
 */
@ToString
@Getter
public class OpRelation {
    /**
     * 选项的控件ID
     */
    private final String key;
    /**
     * 关联的控件列表
     */
    private final List<Relation> relationList;

    /**
     * Instantiates a new Op relation.
     *
     * @param key          the key
     * @param relationList the relation list
     */
    @JsonCreator
    public OpRelation(@JsonProperty("key") String key,
                      @JsonProperty("relation_list") List<Relation> relationList) {
        this.key = key;
        this.relationList = relationList;
    }
}
