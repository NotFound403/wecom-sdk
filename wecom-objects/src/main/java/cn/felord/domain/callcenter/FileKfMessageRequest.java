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

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type File kf message request.
 *
 * @author dax
 * @since 2024/6/4
 */
@ToString
@Getter
public class FileKfMessageRequest extends KfMessageRequest {
    private final MediaId file;


    /**
     * Instantiates a new File kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param mediaId  the media id
     */
    public FileKfMessageRequest(String touser, String openKfid, String mediaId) {
        this(touser, openKfid, null, mediaId);
    }

    /**
     * Instantiates a new File kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param msgid    the msgid
     * @param mediaId  the media id
     */
    public FileKfMessageRequest(String touser, String openKfid, String msgid, String mediaId) {
        super(touser, openKfid, msgid, KfMsgType.FILE);
        this.file = new MediaId(mediaId);
    }
}
