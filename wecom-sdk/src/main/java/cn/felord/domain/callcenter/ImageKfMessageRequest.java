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

package cn.felord.domain.callcenter;

import cn.felord.domain.common.MediaId;
import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@ToString
@Getter
public class ImageKfMessageRequest extends KfMessageRequest {
    private final MediaId image;


    public ImageKfMessageRequest(String touser, String openKfid, MediaId image) {
        this(touser, openKfid, null, image);
    }

    public ImageKfMessageRequest(String touser, String openKfid, String msgid,  MediaId image) {
        super(touser, openKfid, msgid, KfMsgType.IMAGE);
        this.image = image;
    }
}
