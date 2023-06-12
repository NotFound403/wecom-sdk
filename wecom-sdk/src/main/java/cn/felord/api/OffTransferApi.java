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
import cn.felord.domain.common.CursorPage;
import cn.felord.domain.externalcontact.OffTransferCustomerRequest;
import cn.felord.domain.externalcontact.TransferCustomerResponse;
import cn.felord.domain.externalcontact.TransferFailedGroupChat;
import cn.felord.domain.externalcontact.TransferGroupChatRequest;
import cn.felord.domain.externalcontact.TransferResultRequest;
import cn.felord.domain.externalcontact.TransferResultResponse;
import cn.felord.domain.externalcontact.UnassignedListResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Set;

/**
 * 离职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public class OffTransferApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Off transfer api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    OffTransferApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }


    /**
     * 获取待分配的离职成员列表
     *
     * @param cursor   the cursor
     * @param pageSize the page size
     * @return TransferCustomerResponse transfer customer response
     */
    public UnassignedListResponse getUnassignedList(String cursor, int pageSize) {
        CursorPage pageRequest = new CursorPage(cursor, pageSize);
        return workWeChatApiClient.post(WeComEndpoint.UNASSIGNED_LIST, pageRequest, UnassignedListResponse.class);
    }


    /**
     * 分配离职成员的客户
     *
     * @param request the request
     * @return the transfer customer response
     */
    public TransferCustomerResponse transferCustomer(OffTransferCustomerRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OFF_TRANSFER_CUSTOMER, request, TransferCustomerResponse.class);
    }

    /**
     * 查询离职成员客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     */
    public TransferResultResponse transferResult(TransferResultRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OFF_TRANSFER_RESULT, request, TransferResultResponse.class);
    }

    /**
     * 分配离职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     */
    public GenericResponse<Set<TransferFailedGroupChat>> transferGroupChat(TransferGroupChatRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OFF_TRANSFER_GROUP_CHAT, request, new ParameterizedTypeReference<GenericResponse<Set<TransferFailedGroupChat>>>() {
        });
    }
}
