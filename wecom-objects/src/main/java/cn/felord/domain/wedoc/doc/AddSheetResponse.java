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

package cn.felord.domain.wedoc.doc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 新增子表操作的请求响应体结构
 *
 * @author dax
 * @since 2024 /8/16
 */
@ToString
@Getter
public class AddSheetResponse {
    private final SheetProperties properties;

    /**
     * Instantiates a new Add sheet response.
     *
     * @param properties the properties
     */
    @JsonCreator
    AddSheetResponse(@JsonProperty("properties") SheetProperties properties) {
        this.properties = properties;
    }
}
