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

package cn.felord.wecom.service.callback;

import cn.felord.domain.callback.CallbackEventBody;
import cn.felord.enumeration.CallbackEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 兜底回调处理事件，不可注册为Spring Bean
 *
 * @author xiafang
 * @since 2023/6/10 10:49
 */
@Slf4j
public final class NotMatchedCallbackEventBodyConsumer implements CallbackEventBodyConsumer {
    public static final CallbackEventBodyConsumer INSTANCE = new NotMatchedCallbackEventBodyConsumer();

    private NotMatchedCallbackEventBodyConsumer() {
    }

    @Override
    public boolean matched(CallbackEvent event) {
        throw new IllegalArgumentException("NotFoundCallbackEventBodyConsumer 不得自动加入消费链");
    }

    @Override
    public void consume(CallbackEventBody body) {
        log.info("未找到合适的事件消费处理器，事件参数BODY：{}", body);
    }
}
