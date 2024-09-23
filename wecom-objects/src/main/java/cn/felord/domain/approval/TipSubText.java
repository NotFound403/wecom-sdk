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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The type Tip sub text.
 *
 * @param <CONTENT> the type parameter
 * @author dax
 * @since 2024/1/24
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextTipSubText.class, name = "1"),
        @JsonSubTypes.Type(value = LinkTipSubText.class, name = "2")})
@ToString
@Getter
public abstract class TipSubText<CONTENT> {
    private final TipsCtrlType type;
    private final CONTENT content;

    /**
     * Instantiates a new Tip sub text.
     *
     * @param type    the type
     * @param content the content
     */
    TipSubText(TipsCtrlType type, CONTENT content) {
        this.type = type;
        this.content = content;
    }


    /**
     * 纯文本
     *
     * @param content the content
     * @return the tip sub text
     */
    public static TipSubText<TextTipContent> text(@NonNull String content) {
        return new TextTipSubText(TipsCtrlType.TEXT, new TextTipContent(content));
    }

    /**
     * 链接
     *
     * @param title the title
     * @param url   the url
     * @return the tip sub text
     */
    public static TipSubText<LinkTipContent> link(@NonNull String title, @NonNull String url) {
        return new LinkTipSubText(TipsCtrlType.LINK, new LinkTipContent(title, url));
    }
}
