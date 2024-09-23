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

package cn.felord.domain.externalcontact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Moment link.
 *
 * @author dax
 * @since 2021 /8/21 19:34
 */
@ToString
@Getter
public class MomentLink {
    private final String title;
    private final String url;
    private final String mediaId;

    /**
     * Instantiates a new Moment link.
     *
     * @param title   the title
     * @param url     the url
     * @param mediaId the media id
     */
    @JsonCreator
    MomentLink(@JsonProperty("title") String title,
               @JsonProperty("url") String url,
               @JsonProperty("media_id") String mediaId) {
        this.title = title;
        this.url = url;
        this.mediaId = mediaId;
    }
}
