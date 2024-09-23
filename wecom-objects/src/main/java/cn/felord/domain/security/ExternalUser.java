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

package cn.felord.domain.security;

import cn.felord.enumeration.ContactUserType;
import lombok.Data;

/**
 * @author dax
 * @since 2023/10/9
 */
@Data
public class ExternalUser {
    /**
     * 用户类型
     */
    private ContactUserType type;
    /**
     * 用户名
     */
    private String name;
    /**
     * 企业名，当用户为企业微信用户时，返回该字段
     */
    private String corpName;
}
