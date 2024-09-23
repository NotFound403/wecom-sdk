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

package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * The type Attachment horizontal content.
 *
 * @author felord.cn
 * @since 2021 /9/3 15:31
 */
@Getter
public class AttachmentHorizontalContent extends HorizontalContent {
    private final String mediaId;

    /**
     * Instantiates a new Attachment horizontal content.
     *
     * @param keyname the keyname
     * @param mediaId the media id
     */
    public AttachmentHorizontalContent(String keyname, String mediaId) {
        this(keyname, mediaId, null);
    }

    /**
     * Instantiates a new Attachment horizontal content.
     *
     * @param keyname the keyname
     * @param mediaId the media id
     * @param value   the value
     */
    public AttachmentHorizontalContent(String keyname, String mediaId, String value) {
        super(HorizontalContentType.ATTACHMENT, keyname, value);
        this.mediaId = mediaId;
    }
}
