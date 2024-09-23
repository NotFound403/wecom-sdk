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
 * The type Image.
 *
 * @author dax
 * @since 2021 /8/23 19:50
 */
@ToString
@Getter
public class Image {
    private final String mediaId;
    private final String picUrl;

    /**
     * Instantiates a new Image.
     *
     * @param mediaId the media id
     * @param picUrl  the pic url
     */
    @JsonCreator
    Image(@JsonProperty("media_id") String mediaId, @JsonProperty("pic_url") String picUrl) {
        this.mediaId = mediaId;
        this.picUrl = picUrl;
    }

    /**
     * With media id image.
     *
     * @param mediaId the media id
     * @return the image
     */
    public static Image withMediaId(String mediaId) {
        return new Image(mediaId, null);
    }

    /**
     * With pic url image.
     *
     * @param picUrl the pic url
     * @return the image
     */
    public static Image withPicUrl(String picUrl) {
        return new Image(null, picUrl);
    }
}
