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

package cn.felord.domain.common;

import lombok.Data;

/**
 * The type Job id.
 *
 * @author dax
 * @since 2023 /6/28 16:14
 */
@Data
public class JobId {
    private final String jobid;

    /**
     * Of job id.
     *
     * @param jobid the jobid
     * @return the job id
     */
    public static JobId of(String jobid) {
        return new JobId(jobid);
    }
}
