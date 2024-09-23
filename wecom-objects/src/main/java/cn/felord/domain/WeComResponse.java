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

package cn.felord.domain;

import lombok.Data;

/**
 * The type Abstract response.
 *
 * @author n1
 * @since 2021 /6/16 9:53
 */
@Data
public class WeComResponse {
    private Integer errcode;
    private String errmsg;


    /**
     * Is successful response.
     *
     * @return the boolean
     */
    public boolean isSuccessful() {
        return errcode == 0;
    }

    /**
     * Is error response.
     *
     * @return the boolean
     */
    public boolean isError() {
        return errcode != null && errcode != 0;
    }
}
