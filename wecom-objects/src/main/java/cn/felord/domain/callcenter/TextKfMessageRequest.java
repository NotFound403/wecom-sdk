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

import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Text kf message request.
 *
 * @author dax
 * @since 2024/6/4
 */
@ToString
@Getter
public class TextKfMessageRequest extends KfMessageRequest {
    private final KfMessageText text;


    /**
     * Instantiates a new Text kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param content  the content
     */
    public TextKfMessageRequest(String touser, String openKfid, String content) {
        this(touser, openKfid, null, content);
    }

    /**
     * Instantiates a new Text kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param msgid    the msgid
     * @param content  the content
     */
    public TextKfMessageRequest(String touser, String openKfid, String msgid, String content) {
        super(touser, openKfid, msgid, KfMsgType.TEXT);
        this.text = new KfMessageText(content);
    }

}
