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

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.MsgAttachType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The type File msg attachment.
 *
 * @author dax
 * @since 2021 /4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class FileMsgAttachment extends MsgAttachment {
    private final MediaId file;

    /**
     * Instantiates a new File msg attachment.
     *
     * @param file the file
     */
    @JsonCreator
    FileMsgAttachment(@JsonProperty("file") MediaId file) {
        super(MsgAttachType.FILE);
        this.file = file;
    }

    /**
     * Instantiates a new File msg attachment.
     *
     * @param fileMediaId the file media id
     */
    public FileMsgAttachment(String fileMediaId) {
        this(new MediaId(fileMediaId));
    }
}
