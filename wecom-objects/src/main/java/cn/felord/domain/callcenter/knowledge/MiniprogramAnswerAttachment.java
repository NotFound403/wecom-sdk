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

import cn.felord.domain.callcenter.KfMiniprogram;
import cn.felord.enumeration.AnswerAttachType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Miniprogram answer attachment.
 *
 * @author dax
 * @since 2024/10/5
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
public class MiniprogramAnswerAttachment extends AnswerAttachment {
    private final KfMiniprogram miniprogram;

    /**
     * Instantiates a new Miniprogram answer attachment.
     *
     * @param miniprogram the miniprogram
     */
    @JsonCreator
    MiniprogramAnswerAttachment(@JsonProperty("miniprogram") KfMiniprogram miniprogram) {
        super(AnswerAttachType.MINIPROGRAM);
        this.miniprogram = miniprogram;
    }

    /**
     * From miniprogram answer attachment.
     *
     * @param appid        the appid
     * @param pagepath     the pagepath
     * @param thumbMediaId the thumb media id
     * @return the miniprogram answer attachment
     */
    public static MiniprogramAnswerAttachment from(String appid, String pagepath, String thumbMediaId) {
        return from(appid, pagepath, thumbMediaId, null);
    }

    /**
     * From miniprogram answer attachment.
     *
     * @param appid        the appid
     * @param pagepath     the pagepath
     * @param thumbMediaId the thumb media id
     * @param title        the title
     * @return the miniprogram answer attachment
     */
    public static MiniprogramAnswerAttachment from(String appid, String pagepath, String thumbMediaId, String title) {
        KfMiniprogram kfMiniprogram = new KfMiniprogram();
        kfMiniprogram.setAppid(appid);
        kfMiniprogram.setPagepath(pagepath);
        kfMiniprogram.setThumbMediaId(thumbMediaId);
        kfMiniprogram.setTitle(title);
        return new MiniprogramAnswerAttachment(kfMiniprogram);
    }
}
