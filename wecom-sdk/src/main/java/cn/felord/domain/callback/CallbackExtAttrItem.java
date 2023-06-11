/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author dax
 * @since 2022/2/7 14:55
 */
@XStreamAlias("Item")
@Data
public class CallbackExtAttrItem {
    @XStreamAlias("Type")
    private Integer type;
    @XStreamAlias("Name")
    private String name;
    @XStreamAlias("Web")
    private Web web;
    @XStreamAlias("Text")
    private Text text;

    @Data
    public static class Web {
        @XStreamAlias("Title")
        private String title;
        @XStreamAlias("Url")
        private String url;
    }

    @Data
    public static class Text {
        @XStreamAlias("Value")
        private String value;
    }
}
