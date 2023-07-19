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
import cn.felord.enumeration.CallbackChangeType;
import cn.felord.enumeration.CallbackEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 客户群变更事件业务处理
 *
 * @author dax
 * @since 2023/5/30 14:00
 */
@Slf4j
@AllArgsConstructor
@Service
public class ChangeExternalChatCallbackEventBodyConsumer implements CallbackEventBodyConsumer {


    @Override
    public boolean matched(CallbackEvent event) {
        return CallbackEvent.CHANGE_EXTERNAL_CHAT.equals(event);
    }

    @Override
    public void consume(CallbackEventBody body) {
        String chatId = body.getChatId();
        CallbackChangeType changeType = body.getChangeType();
        CallbackEvent event = body.getEvent();

        //TODO 这里编写你的客户群变更事件业务逻辑
    }
}
