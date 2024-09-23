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
 * The AgreeStatus
 *
 * @author dax
 * @since 2021/9/8 10:47
 */
public enum AgreeStatus {
    /**
     * 同意
     */
    AGREE("Agree"),
    /**
     * 不同意
     */
    DISAGREE("Disagree");

    private final String status;

    AgreeStatus(String status) {
        this.status = status;
    }


    @JsonValue
    public String getStatus() {
        return status;
    }

    /**
     * Deserialize AgreeStatus
     *
     * @param status the status
     * @return the AgreeStatus
     */
    @JsonCreator
    public static AgreeStatus deserialize(String status) {
        return Arrays.stream(AgreeStatus.values())
                .filter(contactType -> Objects.equals(status, contactType.status))
                .findFirst()
                .orElse(null);
    }

}
