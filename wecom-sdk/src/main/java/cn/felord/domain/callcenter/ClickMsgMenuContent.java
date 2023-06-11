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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Click msg menu content.
 *
 * @author dax
 * @since 2023 /6/3
 */
@ToString
@Getter
public class ClickMsgMenuContent extends MsgMenuContent {
    private final Click click;

    /**
     * Instantiates a new Click msg menu content.
     *
     * @param click the click
     */
    @JsonCreator
    public ClickMsgMenuContent(@JsonProperty("click") Click click) {
        super(MsgMenuContentType.CLICK);
        this.click = click;
    }

    /**
     * The type Click.
     */
    @Data
    public static class Click{
        private String id;
        private String content;
    }
}
