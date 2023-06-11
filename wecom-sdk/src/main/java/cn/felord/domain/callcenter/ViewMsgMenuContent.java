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
 * The type View msg menu content.
 *
 * @author dax
 * @since 2023 /6/3
 */
@ToString
@Getter
public class ViewMsgMenuContent extends MsgMenuContent {
    private final View view;

    /**
     * Instantiates a new View msg menu content.
     *
     * @param view the view
     */
    @JsonCreator
    public ViewMsgMenuContent(@JsonProperty("view") View view) {
        super(MsgMenuContentType.VIEW);
        this.view = view;
    }

    /**
     * The type View.
     */
    @Data
    public static class View {
        private String url;
        private String content;
    }
}
