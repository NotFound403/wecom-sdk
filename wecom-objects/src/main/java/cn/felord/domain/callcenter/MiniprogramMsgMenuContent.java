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

package cn.felord.domain.callcenter;

import cn.felord.enumeration.MsgMenuContentType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 小程序菜单项
 *
 * @author dax
 * @since 2024/6/3
 */
@ToString
@Getter
public class MiniprogramMsgMenuContent extends MsgMenuContent {
    private final MenuMiniprogram miniprogram;

    /**
     * Instantiates a new Miniprogram msg menu content.
     *
     * @param miniprogram the miniprogram
     */
    @JsonCreator
    MiniprogramMsgMenuContent(@JsonProperty("miniprogram") MenuMiniprogram miniprogram) {
        super(MsgMenuContentType.MINIPROGRAM);
        this.miniprogram = miniprogram;
    }

    /**
     * Instantiates a new Miniprogram msg menu content.
     *
     * @param appid    the appid
     * @param pagepath the pagepath
     * @param content  the content
     */
    public MiniprogramMsgMenuContent(String appid, String pagepath, String content) {
        this(new MenuMiniprogram(appid, pagepath, content));
    }

}
