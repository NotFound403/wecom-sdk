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

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

/**
 * The KfEventType.
 *
 * @author n1
 * @since 2021 /6/16 14:39
 */
public enum KfEventType {
    /**
     * 客服-用户进入会话事件
     */
    ENTER_SESSION("enter_session"),
    /**
     * 客服-消息发送失败事件
     */
    MSG_SEND_FAIL("msg_send_fail"),
    /**
     * 客服-接待人员接待状态变更事件
     */
    SERVICER_STATUS_CHANGE("servicer_status_change"),
    /**
     * 客服-会话状态变更事件
     */
    SESSION_STATUS_CHANGE("session_status_change"),
    /**
     * 客服-用户撤回消息事件
     */
    USER_RECALL_MSG("user_recall_msg"),
    /**
     * 客服-接待人员撤回消息事件
     */
    SERVICER_RECALL_MSG("servicer_recall_msg"),
    /**
     * 客服-拒收客户消息变更事件
     */
    REJECT_CUSTOMER_MSG_SWITCH_CHANGE("reject_customer_msg_switch_change");
    private final String type;

    KfEventType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }

    /**
     * Deserialize range type.
     *
     * @param type the type
     * @return the range type
     */
    @JsonCreator
    public static KfEventType deserialize(String type) {
        return Arrays.stream(KfEventType.values())
                .filter(kfMsgType -> Objects.equals(kfMsgType.type, type))
                .findFirst()
                .orElse(null);
    }
}
