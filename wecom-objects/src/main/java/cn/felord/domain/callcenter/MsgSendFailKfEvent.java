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

import cn.felord.enumeration.FailKfEventType;
import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Msg send fail kf event.
 *
 * @author dax
 * @since 2024/6/4
 */
@ToString
@Getter
public class MsgSendFailKfEvent extends KfEvent {
    private final String externalUserid;
    private final String failMsgid;
    private final FailKfEventType failType;

    /**
     * Instantiates a new Msg send fail kf event.
     *
     * @param openKfid       the open kfid
     * @param externalUserid the external userid
     * @param failMsgid      the fail msgid
     * @param failType       the fail type
     */
    @JsonCreator
    public MsgSendFailKfEvent(@JsonProperty("open_kfid") String openKfid,
                              @JsonProperty("external_userid") String externalUserid,
                              @JsonProperty("fail_msgid") String failMsgid,
                              @JsonProperty("fail_type") FailKfEventType failType) {
        super(KfEventType.MSG_SEND_FAIL, openKfid);
        this.externalUserid = externalUserid;
        this.failMsgid = failMsgid;
        this.failType = failType;
    }
}
