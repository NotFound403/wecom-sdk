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

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 文本菜单
 *
 * @author dax
 * @since 2024/9/15
 */
@ToString
@Getter
public class TextMsgMenuContent extends MsgMenuContent {
    private final MenuText text;

    /**
     * Instantiates a new Text msg menu content.
     *
     * @param text the text
     */
    @JsonCreator
    TextMsgMenuContent(@JsonProperty("text") MenuText text) {
        super(MsgMenuContentType.TEXT);
        this.text = text;
    }

    /**
     * Instantiates a new Text msg menu content.
     *
     * @param content the content
     */
    public TextMsgMenuContent(String content) {
        this(new MenuText(content));
    }

    /**
     * Instantiates a new Text msg menu content.
     *
     * @param content   the content
     * @param noNewline the no newline
     */
    public TextMsgMenuContent(String content, BoolEnum noNewline) {
        this(new MenuText(content, noNewline));
    }
}
