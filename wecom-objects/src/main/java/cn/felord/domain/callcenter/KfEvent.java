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

import cn.felord.enumeration.KfEventType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/6/4
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "event_type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EnterSessionKfEvent.class, name = "enter_session"),
        @JsonSubTypes.Type(value = MsgSendFailKfEvent.class, name = "msg_send_fail"),
        @JsonSubTypes.Type(value = ServicerStatusChangeKfEvent.class, name = "servicer_status_change"),
        @JsonSubTypes.Type(value = SessionStatusChangeKfEvent.class, name = "session_status_change"),
        @JsonSubTypes.Type(value = UserRecallMsgKfEvent.class, name = "user_recall_msg"),
        @JsonSubTypes.Type(value = ServicerRecallMsgKfEvent.class, name = "servicer_recall_msg"),
        @JsonSubTypes.Type(value = RejectCustomerMsgKfEvent.class, name = "reject_customer_msg_switch_change")
})
@ToString
@Getter
public abstract class KfEvent {
    private final KfEventType eventType;
    private final String openKfid;

    public KfEvent(KfEventType eventType, String openKfid) {
        this.eventType = eventType;
        this.openKfid = openKfid;
    }
}
