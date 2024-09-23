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
 * 企业是否验证或认证
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum QualificationStatus {

    /**
     * 未验证
     */
    NOT_VERIFIED(1),
    /**
     * 已验证
     */
    VERIFIED(2),
    /**
     * 表示已认证，已加入的企业返回
     */
    CERTIFIED(3);

    private final int status;

    QualificationStatus(int status) {
        this.status = status;
    }

    /**
     * Deserialize QualificationStatus
     *
     * @param status the status
     * @return the moment task status
     */
    @JsonCreator
    public static QualificationStatus deserialize(int status) {
        return Arrays.stream(QualificationStatus.values())
                .filter(qualificationStatus -> qualificationStatus.status == status)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @JsonValue
    public int getStatus() {
        return status;
    }
}
