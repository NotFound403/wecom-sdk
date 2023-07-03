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

package cn.felord.wecom.service;

import cn.felord.callbacks.CallbackSettings;
import cn.felord.wecom.cache.EhcacheWeComCallbackSettingsCache;
import cn.felord.wecom.entity.WecomCallbackSettings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author dax
 * @since 2023/7/2
 */
@AllArgsConstructor
@Service
public class WecomCallbackSettingsServiceImpl implements WecomCallbackSettingsService {
    private final EhcacheWeComCallbackSettingsCache callbackSettingsCache;

    @Override
    public CallbackSettings loadCallbackSettings(String corpId, String agentId) {
        WecomCallbackSettings settings = callbackSettingsCache.getCallbackSettings(corpId, agentId);
        if (Objects.isNull(settings)) {
            // 从持久层加载 为了演示这里直接new了
            settings = new WecomCallbackSettings();
            // 重新放入缓存
            callbackSettingsCache.putCallbackSettings(corpId, agentId, settings);
        }
        return new CallbackSettings(settings.getToken(), settings.getEncodingAesKey(), settings.getReceiveid());
    }
}
