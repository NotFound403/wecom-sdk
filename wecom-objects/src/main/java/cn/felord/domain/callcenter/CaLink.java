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

/**
 * The type Ca link.
 *
 * @author dax
 * @since 2024/12/22
 */
@ToString
@Getter
public class CaLink {
    private final String linkUrl;

    /**
     * Instantiates a new Ca link.
     *
     * @param linkUrl the link url
     */
    @JsonCreator
    public CaLink(@JsonProperty("link_url") String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
