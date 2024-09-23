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
 * The enum User status.
 *
 * @author dax
 * @since 2021/9/17 11:14
 */
public enum UserStatus {

    /**
     * Activated user status.
     */
    ACTIVATED(1),

    /**
     * Disabled user status.
     */
    DISABLED(2),

    /**
     * Inactivated user status.
     */
    INACTIVATED(4),

    /**
     * Quit user status.
     */
    QUIT(5);

    private final int status;

    UserStatus(int status) {
        this.status = status;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public int getStatus() {
        return status;
    }


    /**
     * Deserialize user status.
     *
     * @param status the status
     * @return the user status
     */
    @JsonCreator
    public static UserStatus deserialize(int status) {
        return Arrays.stream(UserStatus.values())
                .filter(userStatus -> userStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
