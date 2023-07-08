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

import cn.felord.domain.callback.ApprovalInfo;
import cn.felord.domain.callback.CallbackEventBody;
import cn.felord.enumeration.CallbackChangeType;
import cn.felord.enumeration.CallbackEvent;
import cn.felord.enumeration.StatusChangeEvent;
import cn.felord.wecom.service.callback.CallbackEventBodyConsumer;
import cn.felord.wecom.service.callback.NotMatchedCallbackEventBodyConsumer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * 异步独立线程中执行
 *
 * @author dax
 * @since 2023/7/2
 */
@Slf4j
@AllArgsConstructor
@Service
public class WecomCallbackEventServiceImpl implements WecomCallbackEventService {
    private final List<CallbackEventBodyConsumer> callbackEventBodyConsumers;

    @Override
    public void handlerEventBody(CallbackEventBody eventBody) {
        CallbackEvent event = eventBody.getEvent();
        try {
            // 本逻辑在异步独立线程中执行
            //TODO 如果需要持久化以下字段大部分已经能够满足需求  可根据需求调整
            // 相同的回调  msgSignature 一定相同  用来去重
            String msgSignature = eventBody.getMsgSignature();
            String toUserName = eventBody.getToUserName();
            String fromUserName = eventBody.getFromUserName();
            Instant createTime = eventBody.getCreateTime();
            String msgType = eventBody.getMsgType();
            CallbackChangeType changeType = eventBody.getChangeType();
            String agentId = eventBody.getAgentId();
            String nonce = eventBody.getNonce();
            String timeStamp = eventBody.getTimeStamp();
            String encrypt = eventBody.getEncrypt();
            // 原始xml 报文
            String originalXml = eventBody.getOriginalXml();
            ApprovalInfo approvalInfo = eventBody.getApprovalInfo();
            if (Objects.nonNull(approvalInfo)) {
                StatusChangeEvent statuChangeEvent = approvalInfo.getStatuChangeEvent();
            }

        } catch (Exception e) {
            log.error("callback event error：{},body：{}", e, eventBody);
        } finally {
            //TODO 参考事件类型的具体实现 来匹配  匹配到就处理，匹配不到由兜底NotMatchedCallbackEventBodyConsumer处理
            callbackEventBodyConsumers
                    .stream()
                    .filter(callbackEventBodyConsumer ->
                            callbackEventBodyConsumer.matched(event))
                    .findAny()
                    .orElse(NotMatchedCallbackEventBodyConsumer.INSTANCE)
                    .consume(eventBody);
        }
    }
}
