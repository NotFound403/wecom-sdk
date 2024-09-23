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

package cn.felord.domain.callcenter.knowledge;

import cn.felord.domain.common.Name;
import cn.felord.enumeration.AnswerAttachType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Video intent attachment.
 *
 * @author dax
 * @since 2024/10/5
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class VideoIntentAttachment extends IntentAttachment {
    private final Name video;


    /**
     * Instantiates a new Video intent attachment.
     *
     * @param video the video
     */
    @JsonCreator
    VideoIntentAttachment(@JsonProperty("video") Name video) {
        super(AnswerAttachType.VIDEO);
        this.video = video;
    }
}
