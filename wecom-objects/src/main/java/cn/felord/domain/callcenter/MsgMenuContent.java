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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dax
 * @since 2023/6/3
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClickMsgMenuContent.class, name = "click"),
        @JsonSubTypes.Type(value = ViewMsgMenuContent.class, name = "view"),
        @JsonSubTypes.Type(value = MiniprogramMsgMenuContent.class, name = "miniprogram"),
        @JsonSubTypes.Type(value = TextMsgMenuContent.class, name = "text")
})
@AllArgsConstructor
@Getter
public abstract class MsgMenuContent {
    private final MsgMenuContentType type;
}
