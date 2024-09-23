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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Kf msg menu.
 *
 * @author dax
 * @since 2024/6/3
 */
@ToString
@Getter
public class KfMsgMenu {
    private String headContent;
    private List<MsgMenuContent> list;
    private String tailContent;

    /**
     * Instantiates a new Kf msg menu.
     *
     * @param headContent the head content
     * @param list        the list
     * @param tailContent the tail content
     */
    @JsonCreator
    KfMsgMenu(@JsonProperty("head_content") String headContent,
              @JsonProperty("list") List<MsgMenuContent> list,
              @JsonProperty("tail_content") String tailContent) {
        this.headContent = headContent;
        this.list = list;
        this.tailContent = tailContent;
    }

    /**
     * Instantiates a new Kf msg menu.
     */
    public KfMsgMenu() {
    }

    /**
     * Sets head content.
     *
     * @param headContent the head content
     * @return the head content
     */
    public KfMsgMenu headContent(String headContent) {
        this.headContent = headContent;
        return this;
    }

    /**
     * Sets list.
     *
     * @param list the list
     * @return the list
     */
    public KfMsgMenu list(List<MsgMenuContent> list) {
        this.list = list;
        return this;
    }

    /**
     * Sets tail content.
     *
     * @param tailContent the tail content
     * @return the tail content
     */
    public KfMsgMenu tailContent(String tailContent) {
        this.tailContent = tailContent;
        return this;
    }
}
