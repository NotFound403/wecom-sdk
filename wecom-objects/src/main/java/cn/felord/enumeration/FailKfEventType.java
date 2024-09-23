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

/**
 * 客服事件失败类型
 *
 * @author n1
 * @since 2021 /6/16 14:39
 */
public enum FailKfEventType {

    /**
     * 未知原因
     */
    UNKNOWN(0),
    /**
     * 客服帐号已删除
     */
    KF_ACC_DELETED(1),
    /**
     * 应用已关闭
     */
    APP_CLOSED(2),
    /**
     * 会话已过期，超过48小时
     */
    SESSION_EXPIRED(4),
    /**
     * 会话已关闭
     */
    SESSION_CLOSED(5),
    /**
     * 超过5条限制
     */
    OUT_OF_5(6),
    /**
     * 未绑定视频号
     */
    NO_CHANNEL(7),
    /**
     * 主体未验证
     */
    NOT_VERIFIED(8),
    /**
     * 未绑定视频号且主体未验证
     */
    NO_CHANNEL_VERIFIED(9),
    /**
     * 用户拒收
     */
    REJECTION(10),
    /**
     * 企业未有成员登录企业微信App
     */
    NO_MEMBER(11);


    private final int type;

    FailKfEventType(int type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getType() {
        return type;
    }

    /**
     * Deserialize type.
     *
     * @param type the type
     * @return the chat type
     */
    @JsonCreator
    public static FailKfEventType deserialize(int type) {
        return Arrays.stream(FailKfEventType.values())
                .filter(failKfEventType -> type == failKfEventType.type)
                .findFirst()
                .orElse(null);
    }
}
