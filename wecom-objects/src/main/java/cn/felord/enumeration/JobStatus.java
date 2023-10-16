/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 任务状态
 *
 * @author dax
 * @since 2021 /9/8 10:47
 */
public enum JobStatus {


    /**
     * 表示任务开始
     */
    BEGINNING(1),

    /**
     * 表示任务进行中
     */
    IN_PROGRESS(2),
    /**
     * 表示任务已完成
     */
    FINISHED(3);

    private final int status;

    JobStatus(int status) {
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
    public static JobStatus deserialize(int status) {
        return Arrays.stream(JobStatus.values())
                .filter(importStatus -> importStatus.status == status)
                .findFirst()
                .orElse(null);
    }
}
