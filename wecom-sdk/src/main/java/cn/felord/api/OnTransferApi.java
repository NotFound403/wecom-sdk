/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.externalcontact.TransferCustomerRequest;
import cn.felord.domain.externalcontact.TransferCustomerResponse;
import cn.felord.domain.externalcontact.TransferFailedGroupChat;
import cn.felord.domain.externalcontact.TransferGroupChatRequest;
import cn.felord.domain.externalcontact.TransferResultRequest;
import cn.felord.domain.externalcontact.TransferResultResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Set;

/**
 * 在职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public class OnTransferApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new On transfer api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    OnTransferApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 分配在职成员的客户
     * <p>
     * 为保障客户服务体验，90个自然日内，在职成员的每位客户仅可被转接2次。
     *
     * @param request the request
     * @return TransferCustomerResponse transfer customer response
     */
    public TransferCustomerResponse transferCustomer(TransferCustomerRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.TRANSFER_CUSTOMER, request, TransferCustomerResponse.class);
    }

    /**
     * 查询客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     */
    public TransferResultResponse transferResult(TransferResultRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.TRANSFER_RESULT, request, TransferResultResponse.class);
    }

    /**
     * 分配在职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     */
    public GenericResponse<Set<TransferFailedGroupChat>> transferGroupChat(TransferGroupChatRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.TRANSFER_GROUP_CHAT, request, new ParameterizedTypeReference<GenericResponse<Set<TransferFailedGroupChat>>>() {
        });
    }
}
