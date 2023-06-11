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

package cn.felord.domain.authentication;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author n1
 * @since 2021/6/16 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProviderTokenResponse extends AbstractTokenResponse {
    private String providerAccessToken;

    @Override
    public String getToken() {
        return providerAccessToken;
    }
}
