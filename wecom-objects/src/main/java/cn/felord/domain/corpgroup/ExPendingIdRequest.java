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

package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * The type Ex pending id request.
 *
 * @author dax
 * @since 2024/10/12
 */
@ToString
@Getter
public class ExPendingIdRequest {
    private final Set<String> externalUserid;
    private String chatId;

    /**
     * Instantiates a new Ex pending id request.
     *
     * @param externalUserid the external userid
     */
    public ExPendingIdRequest(Set<String> externalUserid) {
        this.externalUserid = externalUserid;
    }

    /**
     * Chat id ex pending id request.
     *
     * @param chatId the chat id
     * @return the ex pending id request
     */
    public ExPendingIdRequest chatId(String chatId) {
        this.chatId = chatId;
        return this;
    }
}
