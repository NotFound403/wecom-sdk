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
import cn.felord.domain.externalcontact.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Set;

/**
 * 在职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public interface OnTransferApi {

    /**
     * 分配在职成员的客户
     * <p>
     * 为保障客户服务体验，90个自然日内，在职成员的每位客户仅可被转接2次。
     *
     * @param request the request
     * @return TransferCustomerResponse transfer customer response
     */
    @POST("externalcontact/transfer_customer")
    TransferCustomerResponse transferCustomer(@Body TransferCustomerRequest request) throws WeComException;

    /**
     * 查询客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     */
    @POST("externalcontact/transfer_result")
    TransferResultResponse transferResult(@Body TransferResultRequest request) throws WeComException;

    /**
     * 分配在职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     */
    @POST("externalcontact/groupchat/onjob_transfer")
    GenericResponse<Set<TransferFailedGroupChat>> transferGroupChat(@Body TransferGroupChatRequest request) throws WeComException;
}
