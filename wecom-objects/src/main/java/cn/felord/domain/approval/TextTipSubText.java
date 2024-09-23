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

import cn.felord.enumeration.TipsCtrlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2024/1/24
 */
@ToString(callSuper = true)
@Getter
public class TextTipSubText extends TipSubText<TextTipContent> {
    /**
     * Instantiates a new Tip sub text.
     *
     * @param type    the type
     * @param content the content
     */
    @JsonCreator
    TextTipSubText(@JsonProperty("type") TipsCtrlType type, @JsonProperty("content") TextTipContent content) {
        super(type, content);
    }

}
