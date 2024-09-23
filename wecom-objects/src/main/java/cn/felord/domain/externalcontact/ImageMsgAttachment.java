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

import cn.felord.enumeration.MsgAttachType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2021/4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class ImageMsgAttachment extends MsgAttachment {
    private final Image image;

    @JsonCreator
    ImageMsgAttachment(@JsonProperty("image") Image image) {
        super(MsgAttachType.IMAGE);
        this.image = image;
    }

    /**
     * With media id image.
     *
     * @param mediaId the media id
     * @return the image
     */
    public static ImageMsgAttachment withMediaId(String mediaId) {
        return new ImageMsgAttachment(new Image(mediaId, null));
    }

    /**
     * With pic url image.
     *
     * @param picUrl the pic url
     * @return the image
     */
    public static ImageMsgAttachment withPicUrl(String picUrl) {
        return new ImageMsgAttachment(new Image(null, picUrl));
    }
}
