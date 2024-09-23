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
 * The type Miniprogram msg attachment.
 *
 * @author dax
 * @since 2021 /4/22 14:53
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class MiniprogramMsgAttachment extends MsgAttachment {
    private final MediaMiniprogram miniprogram;

    /**
     * Instantiates a new Miniprogram msg attachment.
     *
     * @param miniprogram the miniprogram
     */
    @JsonCreator
    MiniprogramMsgAttachment(@JsonProperty("miniprogram") MediaMiniprogram miniprogram) {
        super(MsgAttachType.MINIPROGRAM);
        this.miniprogram = miniprogram;
    }

    /**
     * Instantiates a new Miniprogram msg attachment.
     *
     * @param title      the title
     * @param picMediaId the pic media id
     * @param appid      the appid
     * @param page       the page
     */
    public MiniprogramMsgAttachment(String title, String picMediaId, String appid, String page) {
        this(new MediaMiniprogram(title, picMediaId, appid, page));
    }
}
