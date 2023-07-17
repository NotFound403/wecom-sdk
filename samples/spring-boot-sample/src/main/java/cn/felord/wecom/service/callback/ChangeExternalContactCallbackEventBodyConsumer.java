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

import java.util.Objects;

/**
 * 客户变更事件业务处理
 *
 * @author dax
 * @since 2023/5/30 13:42
 */
@Slf4j
@Service
@AllArgsConstructor
public class ChangeExternalContactCallbackEventBodyConsumer implements CallbackEventBodyConsumer {


    @Override
    public boolean matched(CallbackEvent event) {
        return CallbackEvent.CHANGE_EXTERNAL_CONTACT.equals(event);
    }

    @Override
    public void consume(CallbackEventBody body) {
        String externalUserId = body.getExternalUserId();
        CallbackChangeType changeType = body.getChangeType();
        //todo 自行处理客户变更事件业务处理
        if (Objects.equals(changeType, CallbackChangeType.ADD_EXTERNAL_CONTACT)) {
            //TODO 添加客户事件 你也可以在抽成策略细分
        }
    }
}
