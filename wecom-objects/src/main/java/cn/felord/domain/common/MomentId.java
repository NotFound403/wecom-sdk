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
 * The type Moment id.
 *
 * @author dax
 * @since 2023 /5/24 16:04
 */
@Data
public class MomentId {
    private final String momentId;

    /**
     * Of moment id.
     *
     * @param momentId the moment id
     * @return the moment id
     */
    public static MomentId of(String momentId) {
        return new MomentId(momentId);
    }
}
