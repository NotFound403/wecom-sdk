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

package cn.felord.domain.contactbook.user;

import cn.felord.enumeration.EmailType;
import lombok.Getter;

/**
 * The type Email user request.
 *
 * @author dax
 * @since 2024/5/24 10:32
 */
@Getter
public class EmailUserRequest {
    private final String email;
    private final int emailType;

    /**
     * Instantiates a new Email user request.
     *
     * @param email     the email
     * @param emailType the email type
     */
    public EmailUserRequest(String email, EmailType emailType) {
        this.email = email;
        this.emailType = emailType.type();
    }
}
