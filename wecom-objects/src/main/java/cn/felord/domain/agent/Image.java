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

package cn.felord.domain.agent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Image.
 *
 * @author dax
 * @since 2024/10/25
 */
@ToString
@Getter
public class Image implements WorkBenchBody {
    private final String url;
    private String pagepath;
    private String jumpUrl;

    /**
     * Instantiates a new Image.
     *
     * @param url      the url
     * @param pagepath the pagepath
     * @param jumpUrl  the jump url
     */
    @JsonCreator
    Image(@JsonProperty("url") String url,
          @JsonProperty("pagepath") String pagepath,
          @JsonProperty("jump_url") String jumpUrl) {
        this.url = url;
        this.pagepath = pagepath;
        this.jumpUrl = jumpUrl;
    }

    /**
     * Instantiates a new Image.
     *
     * @param url the url
     */
    public Image(String url) {
        this.url = url;
    }

    /**
     * Pagepath image.
     *
     * @param pagepath the pagepath
     * @return the image
     */
    public Image pagepath(String pagepath) {
        this.pagepath = pagepath;
        return this;
    }

    /**
     * Jump url image.
     *
     * @param jumpUrl the jump url
     * @return the image
     */
    public Image jumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
        return this;
    }
}
