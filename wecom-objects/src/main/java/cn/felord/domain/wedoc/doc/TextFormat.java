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
 * 文本样式信息
 *
 * @author dax
 * @since 2024/8/16
 */
@ToString
@Getter
public class TextFormat {
    /**
     * 字体颜色
     */
    private final Color color;
    /**
     * 下划线
     */
    private final Boolean underline;
    /**
     * 字体大小，最大72
     */
    private final Integer fontSize;
    /**
     * 字体加粗
     */
    private final Boolean bold;
    /**
     * 字体删除线
     */
    private final Boolean strikethrough;
    /**
     * 斜体
     */
    private final Boolean italic;
    /**
     * 字体名称，表格支持的字体类型
     *
     * @see <a href="https://developer.work.weixin.qq.com/document/path/97661#%E5%AD%97%E4%BD%93%E5%88%97%E8%A1%A8">字体列表</a>
     */
    private final String font;


    @JsonCreator
    TextFormat(@JsonProperty("color") Color color,
               @JsonProperty("underline") Boolean underline,
               @JsonProperty("font_size") Integer fontSize,
               @JsonProperty("bold") Boolean bold,
               @JsonProperty("strikethrough") Boolean strikethrough,
               @JsonProperty("italic") Boolean italic,
               @JsonProperty("font") String font) {
        this.color = color;
        this.underline = underline;
        this.fontSize = fontSize;
        this.bold = bold;
        this.strikethrough = strikethrough;
        this.italic = italic;
        this.font = font;
    }
}
