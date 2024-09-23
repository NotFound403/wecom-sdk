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
 * The WwShareCode
 *
 * @author dax
 * @since 2024/11/23
 */
@Data
public class WwShareCode {
    /**
     * “推广产品”直播观众跳转小程序商城时会在小程序path中带上ww_share_code=xxxxx参数，ww_share_code五分钟内有效
     */
    private final String wwShareCode;
}
