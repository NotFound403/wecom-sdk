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

package cn.felord.domain.living;

import lombok.Data;

/**
 * @author dax
 * @since 2023/11/23
 */
@Data
public class UserLivingsRequest {
    /**
     * 企业成员的userid
     */
    private final String userid;
    /**
     * 上一次调用时返回的next_cursor，第一次拉取可以不填
     */
    private String cursor;
    /**
     * 每次拉取的数据量，建议填20，默认值和最大值都为100
     */
    private Integer limit;
}
