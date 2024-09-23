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

package cn.felord.domain.message;

import cn.felord.enumeration.BoolEnum;
import cn.felord.enumeration.MessageSafe;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Message body.
 *
 * @author felord
 * @since 2021 /11/22 16:01
 */
@ToString
@Getter
public abstract class AbstractMessageBody {
    private final String msgtype;
    private String agentid;
    private final String touser;
    private final String toparty;
    private final String totag;
    private final MessageSafe safe;
    private final BoolEnum enableDuplicateCheck;
    private final Integer duplicateCheckInterval;

    public AbstractMessageBody(String msgtype, String touser, String toparty, String totag, MessageSafe safe, BoolEnum enableDuplicateCheck, Integer duplicateCheckInterval) {
        this.msgtype = msgtype;
        this.touser = touser;
        this.toparty = toparty;
        this.totag = totag;
        this.safe = safe;
        this.enableDuplicateCheck = enableDuplicateCheck;
        this.duplicateCheckInterval = duplicateCheckInterval;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }
}
