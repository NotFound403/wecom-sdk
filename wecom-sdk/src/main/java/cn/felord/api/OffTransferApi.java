/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.common.CursorPage;
import cn.felord.domain.externalcontact.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Set;

/**
 * 离职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public interface OffTransferApi {

    /**
     * 获取待分配的离职成员列表
     *
     * @param cursorPage the cursor page
     * @return TransferCustomerResponse transfer customer response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_unassigned_list")
    UnassignedListResponse getUnassignedList(@Body CursorPage cursorPage) throws WeComException;


    /**
     * 分配离职成员的客户
     *
     * @param request the request
     * @return the transfer customer response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/resigned/transfer_customer")
    TransferCustomerResponse transferCustomer(@Body OffTransferCustomerRequest request) throws WeComException;

    /**
     * 查询离职成员客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/resigned/transfer_result")
    TransferResultResponse transferResult(@Body TransferResultRequest request) throws WeComException;

    /**
     * 分配离职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/groupchat/transfer")
    GenericResponse<Set<TransferFailedGroupChat>> transferGroupChat(@Body TransferGroupChatRequest request) throws WeComException;
}
