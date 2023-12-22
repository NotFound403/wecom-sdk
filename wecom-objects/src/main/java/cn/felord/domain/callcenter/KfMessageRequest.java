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

import cn.felord.enumeration.KfMsgType;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Kf message request.
 *
 * @author dax
 * @since 2023 /6/4
 */
@ToString
@Getter
public abstract class KfMessageRequest {
    private final String touser;
    private final String openKfid;
    private final String msgid;
    private final KfMsgType msgtype;


    /**
     * Instantiates a new Kf message request.
     *
     * @param touser   the touser
     * @param openKfid the open kfid
     * @param msgid    the msgid
     * @param msgtype  the msgtype
     */
    public KfMessageRequest(String touser, String openKfid, String msgid, KfMsgType msgtype) {
        this.touser = touser;
        this.openKfid = openKfid;
        this.msgid = msgid;
        this.msgtype = msgtype;
    }
}
