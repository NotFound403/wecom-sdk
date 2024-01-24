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

package cn.felord.wecom.configure;

import cn.felord.WeComTokenCacheable;
import cn.felord.api.WorkWeChatApi;
import cn.felord.callbacks.CallbackCrypto;
import cn.felord.callbacks.CallbackCryptoBuilder;
import cn.felord.wecom.cache.EhcacheWeComCallbackSettingsCache;
import cn.felord.wecom.cache.EhcacheWeComTokenCacheable;
import cn.felord.wecom.service.WecomCallbackEventService;
import cn.felord.wecom.service.WecomCallbackSettingsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Wecom Sdk 配置
 *
 * @author dax
 * @since 2024/5/30
 */
@Configuration(proxyBeanMethods = false)
public class WecomSdkConfiguration {

    /**
     * 企微token，ticket 缓存中继，这里使用ehcache作为例子，你可以无缝替换为redis等缓存中间件
     * <p>
     * wecom-sdk 不提供具体的缓存实现，只做抽象，用什么用什么实现就是了，记得设置缓存时间7200
     *
     * @return the we com token cacheable
     */
    @Bean
    WeComTokenCacheable weComTokenCacheable() {
        return new EhcacheWeComTokenCacheable();
    }

    /**
     * 回调配置缓存，该缓存并非wecom要求，实际开发中建议安排上
     *
     * @return the ehcache we com callback settings cache
     */
    @Bean
    EhcacheWeComCallbackSettingsCache ehcacheWeComCallbackSettingsCache() {
        return new EhcacheWeComCallbackSettingsCache();
    }


    /**
     * 初始化 企微API客户端，这个是平常我们发起调用的入口
     * <p>
     * 例子参见 test 测试包下的 SpringBootWecomSdkTests
     *
     * @param weComTokenCacheable the we com token cacheable
     * @return the work we chat api
     */
    @Bean
    WorkWeChatApi workWeChatApi(WeComTokenCacheable weComTokenCacheable) {
        return new WorkWeChatApi(weComTokenCacheable);
    }

    /**
     * 回调配置
     *
     * @param wecomCallbackEventService 统一消费回调数据
     * @param settingsService           统一加载回调配置
     * @return the callback crypto
     */
    @Bean
    public CallbackCrypto callbackCrypto(WecomCallbackEventService wecomCallbackEventService, WecomCallbackSettingsService settingsService) {
        return new CallbackCryptoBuilder(wecomCallbackEventService::handlerEventBody)
                .build(settingsService::loadCallbackSettings);
    }


}
