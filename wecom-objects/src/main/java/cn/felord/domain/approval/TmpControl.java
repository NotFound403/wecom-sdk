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

import cn.felord.json.TmpControlDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.ToString;

/**
 * 控件
 *
 * @author dax
 * @since 2023/5/25 14:42
 */
@ToString
@Getter
@JsonDeserialize(using = TmpControlDeserializer.class)
public class TmpControl<C extends ControlConfig> {
    private final CtrlProperty property;
    private final C config;

    @JsonCreator
    public TmpControl(@JsonProperty("property") CtrlProperty property, @JsonProperty("config") C config) {
        this.property = property;
        this.config = config;
    }
}
