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
 * 获客链接
 *
 * @author dax
 * @since 2024/12/22
 */
@ToString
@Getter
public class CaLinkKfMessageRequest extends KfMessageRequest {
    private final CaLink caLink;

    /**
     * Instantiates a new Ca link kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param linkUrl  the link url
     */
    public CaLinkKfMessageRequest(String touser, String openKfid, String linkUrl) {
        this(touser, openKfid, null, linkUrl);
    }

    /**
     * Instantiates a new Ca link kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param msgid    the msgid
     * @param linkUrl  the link url
     */
    public CaLinkKfMessageRequest(String touser, String openKfid, String msgid, String linkUrl) {
        super(touser, openKfid, msgid, KfMsgType.CA_LINK);
        this.caLink = new CaLink(linkUrl);
    }
}
