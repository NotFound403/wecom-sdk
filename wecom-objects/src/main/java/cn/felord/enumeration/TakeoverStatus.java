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
 * The enum Takeover status.
 *
 * @author dax
 * @since 2021/9/14 14:44
 */
public enum TakeoverStatus {
    /**
     * Finished takeover status.
     */
    FINISHED(1),
    /**
     * Pending takeover status.
     */
    PENDING(2),
    /**
     * Refused takeover status.
     */
    REFUSED(3),
    /**
     * Exceeded takeover status.
     */
    EXCEEDED(4);

    private final int status;

    TakeoverStatus(int status) {
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
     * Deserialize takeover status.
     *
     * @param status the status
     * @return the takeover status
     */
    @JsonCreator
    public static TakeoverStatus deserialize(int status) {
        return Arrays.stream(TakeoverStatus.values())
                .filter(takeoverStatus -> takeoverStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
