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

package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Media id.
 *
 * @author dax
 * @since 2021 /11/22 15:01
 */
@ToString
@Getter
public class MediaId {
    @XStreamAlias("MediaId")
    private final String mediaId;

    /**
     * Instantiates a new Media id.
     *
     * @param mediaId the media id
     */
    @JsonCreator
    public MediaId(@JsonProperty("media_id") String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * Of media id.
     *
     * @param mediaId the media id
     * @return the media id
     */
    public static MediaId of(String mediaId) {
        return new MediaId(mediaId);
    }
}
