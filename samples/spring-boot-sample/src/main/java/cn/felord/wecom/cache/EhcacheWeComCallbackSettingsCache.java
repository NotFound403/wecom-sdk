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

package cn.felord.wecom.cache;

import cn.felord.wecom.entity.WecomCallbackSettings;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * 回调配置缓存
 *
 * @author dax
 * @since 2023/7/2
 */
public class EhcacheWeComCallbackSettingsCache {
    private static final String QYWX_CALLBACK_CACHE = "callback::qywx";

    @CachePut(value = {QYWX_CALLBACK_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    public WecomCallbackSettings putCallbackSettings(@NotNull String corpId, @NotNull String agentId, @NotNull WecomCallbackSettings settings) {
        return settings;
    }

    @Cacheable(value = {QYWX_CALLBACK_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    public WecomCallbackSettings getCallbackSettings(@NotNull String corpId, @NotNull String agentId) {
        return null;
    }

    @CacheEvict(value = {QYWX_CALLBACK_CACHE}, key = "#corpId.concat('::').concat(#agentId)")
    public void clearCallbackSettings(String corpId, String agentId) {

    }
}
