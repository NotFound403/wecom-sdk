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

package cn.felord.domain.wedoc.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 收集表问题带配置，替代{@link FormQuestion}
 *
 * @author dax
 * @since 2024/3/13 16:33
 */
@ToString
@Getter
public class SettingFormQuestion {
    private final List<SettingFormItem<?>> items;

    /**
     * Instantiates a new Setting form question.
     *
     * @param items the items
     */
    @JsonCreator
    public SettingFormQuestion(@JsonProperty("items") List<SettingFormItem<?>> items) {
        this.items = items;
    }
}
