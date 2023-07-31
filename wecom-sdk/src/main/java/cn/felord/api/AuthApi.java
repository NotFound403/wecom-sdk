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

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.contactbook.user.UserDetailResponse;
import cn.felord.domain.contactbook.user.UserSensitiveInfoResponse;
import cn.felord.domain.contactbook.user.UserTicket;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 身份验证API
 *
 * @author felord.cn
 * @since 2021 /9/3 9:17
 */
public interface AuthApi {

    /**
     * 获取访问用户身份
     * <p>
     * 该接口用于根据code获取成员信息，适用于自建应用与代开发应用
     *
     * @param code 通过成员授权获取到的code
     * @return UserDetailResponse user info
     * @throws WeComException the weComException
     */
    @GET("auth/getuserinfo")
    UserDetailResponse getUserInfo(@Query("code") String code) throws WeComException;

    /**
     * 获取访问用户敏感信息，需要授权scope包含{@code snsapi_privateinfo}
     * <p>
     * 自建应用与代开发应用可通过该接口获取成员授权的敏感字段
     *
     * @param userTicket 成员票据
     * @return UserSensitiveInfoResponse user detail
     * @throws WeComException the weComException
     */
    @POST("auth/getuserdetail")
    UserSensitiveInfoResponse getUserDetail(@Body UserTicket userTicket) throws WeComException;
}
