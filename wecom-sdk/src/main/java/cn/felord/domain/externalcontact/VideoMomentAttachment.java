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

package cn.felord.domain.externalcontact;

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.MomentAttachmentType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author dax
 * @since 2021/7/23 15:15
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class VideoMomentAttachment extends MomentAttachment {
    private final MediaId video;

    public VideoMomentAttachment(String mediaId) {
        super(MomentAttachmentType.VIDEO);
        this.video = new MediaId(mediaId);
    }
}
