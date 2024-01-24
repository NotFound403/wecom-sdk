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

import cn.felord.callback.CallbackSettings;

/**
 * The interface Wecom callback settings service.
 *
 * @author dax
 * @since 2024/7/2
 */
public interface WecomCallbackSettingsService {

    /**
     * 加载回调配置，这里建议实现为增加几分钟的缓存，有从缓存中拿，没有从数据库拿
     * <p>
     * CallbackSettings 为有参数构造，建议缓存使用你自定义的装载类来转换
     *
     * @param corpId  the corp id
     * @param agentId the agent id
     * @return the callback settings
     */
    CallbackSettings loadCallbackSettings(String corpId, String agentId);
}
