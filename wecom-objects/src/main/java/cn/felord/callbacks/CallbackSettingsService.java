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

package cn.felord.callbacks;


import cn.felord.callback.CallbackSettings;

/**
 * The interface Callback authentication service.
 *
 * @author felord
 * @since 2021 /11/21 12:13
 */
public interface CallbackSettingsService {
    /**
     * Load authentication callback authentication.
     *
     * @param agentId the agent id
     * @param corpId  the corp id
     * @return the callback authentication
     */
    CallbackSettings loadAuthentication(String agentId, String corpId);
}
