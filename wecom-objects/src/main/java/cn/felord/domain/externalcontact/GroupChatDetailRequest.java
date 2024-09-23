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

package cn.felord.domain.externalcontact;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Group chat detail request.
 *
 * @author dax
 * @since 2021 /7/15 19:46
 */
@ToString
@Getter
public class GroupChatDetailRequest {
    private final String chatId;
    private final Integer needName;

    private GroupChatDetailRequest(String chatId, Integer needName) {
        this.chatId = chatId;
        this.needName = needName;
    }

    /**
     * 需要返回群成员的名字
     *
     * @param chatId the chat id
     * @return the group chat detail request
     */
    public static GroupChatDetailRequest withName(String chatId) {
        return new GroupChatDetailRequest(chatId, 1);
    }

    /**
     * 不需要返回群成员的名字
     *
     * @param chatId the chat id
     * @return the group chat detail request
     */
    public static GroupChatDetailRequest withoutName(String chatId) {
        return new GroupChatDetailRequest(chatId, 0);
    }
}
