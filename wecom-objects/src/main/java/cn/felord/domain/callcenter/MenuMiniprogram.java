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
 * The type Miniprogram.
 *
 * @author n1
 */
@ToString
@Getter
public class MenuMiniprogram {
    private final String appid;
    private final String pagepath;
    private final String content;

    /**
     * Instantiates a new Miniprogram.
     *
     * @param appid    the appid
     * @param pagepath the pagepath
     * @param content  the content
     */
    @JsonCreator
    public MenuMiniprogram(@JsonProperty("appid") String appid,
                           @JsonProperty("pagepath") String pagepath,
                           @JsonProperty("content") String content) {
        this.appid = appid;
        this.pagepath = pagepath;
        this.content = content;
    }
}
