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

import cn.felord.callbacks.CallbackEventBody;
import cn.felord.enumeration.CallbackEvent;

/**
 * 消费企业微信回调
 * <p>
 * 一个{@link CallbackEvent} 对应一个实现
 *
 * @author dax
 * @since 2024/5/30 11:16
 */
public interface CallbackEventBodyConsumer {

    /**
     * 匹配的回调事件
     *
     * @param event the event
     * @return the boolean
     */
    boolean matched(CallbackEvent event);

    /**
     * 消费数据
     *
     * @param body the body
     */
    void consume(CallbackEventBody body);

}
