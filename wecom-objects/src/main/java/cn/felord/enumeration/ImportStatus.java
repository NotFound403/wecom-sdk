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
 * 导入状态
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum ImportStatus {


    /**
     * 全部企业导入成功
     */
    ALL(1),

    /**
     * 部分成功
     */
    PARTIALLY(2),
    /**
     * 全部企业导入失败
     */
    NONE(3);

    private final int status;

    ImportStatus(int status) {
        this.status = status;
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

    /**
     * Deserialize importStatus
     *
     * @param status the status
     * @return the moment task status
     */
    @JsonCreator
    public static ImportStatus deserialize(int status) {
        return Arrays.stream(ImportStatus.values())
                .filter(importStatus -> importStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
