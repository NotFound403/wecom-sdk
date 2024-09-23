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
 * The type Selector key.
 *
 * @author dax
 * @since 2024 /9/12
 */
@ToString
@Getter
public class SelectorKey {
    private final String key;
    private final ApprovalTitle value;


    /**
     * Instantiates a new Selector key.
     *
     * @param key the key
     */
    public SelectorKey(String key) {
        this(key, null);
    }

    /**
     * Instantiates a new Selector key.
     *
     * @param key   the key
     * @param value the value
     */
    @JsonCreator
    SelectorKey(@JsonProperty("key") String key, @JsonProperty("value") ApprovalTitle value) {
        this.key = key;
        this.value = value;
    }
}
