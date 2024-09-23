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

package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Name.
 *
 * @author dax
 * @since 2024 /10/5
 */
@ToString
@Getter
public class Name {
    private final String name;

    /**
     * Instantiates a new Name.
     *
     * @param name the name
     */
    @JsonCreator
    public Name(@JsonProperty("name") String name) {
        this.name = name;
    }

    /**
     * Of name.
     *
     * @param name the name
     * @return the name
     */
    public static Name of(String name) {
        return new Name(name);
    }
}
