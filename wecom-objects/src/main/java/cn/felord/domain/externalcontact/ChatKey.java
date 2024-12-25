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

/**
 * @author dax
 * @since 2024/10/17
 */
@Getter
public class ChatKey {
    private final String chatKey;

    /**
     * Instantiates a new Chat key.
     *
     * @param chatKey the chat key
     */
    ChatKey(String chatKey) {
        this.chatKey = chatKey;
    }

    /**
     * Of chat key.
     *
     * @param chatKey the chat key
     * @return the chat key
     */
    public static ChatKey of(String chatKey) {
        return new ChatKey(chatKey);
    }
}
