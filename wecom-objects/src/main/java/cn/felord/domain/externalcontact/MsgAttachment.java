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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type Msg attachment.
 *
 * @author dax
 * @since 2021 /7/23 15:12
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "msgtype", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FileMsgAttachment.class, name = "file"),
        @JsonSubTypes.Type(value = ImageMsgAttachment.class, name = "image"),
        @JsonSubTypes.Type(value = LinkMsgAttachment.class, name = "link"),
        @JsonSubTypes.Type(value = MiniprogramMsgAttachment.class, name = "miniprogram"),
        @JsonSubTypes.Type(value = VideoMsgAttachment.class, name = "video"),
})
@AllArgsConstructor
@Getter
public abstract class MsgAttachment {
    private final MsgAttachType msgtype;
}
