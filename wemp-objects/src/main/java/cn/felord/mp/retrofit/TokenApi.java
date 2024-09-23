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

package cn.felord.mp.retrofit;


import cn.felord.mp.MpApp;

/**
 * The interface Token api.
 *
 * @author dax
 * @since 2021 /10/7 17:33
 */
public interface TokenApi {
    /**
     * 获取Token
     *
     * @return the token response
     */
    String getToken();

    /**
     * Gets agent details.
     *
     * @return the agent details
     */
    MpApp mpApp();

    /**
     * 清除缓存
     */
    void clearToken();
}
