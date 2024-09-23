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
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 客户联系「联系我」管理
 *
 * @author dax
 * @since 2021 /9/8 9:28
 */
public interface ContactMeWayApi {

    /**
     * 获取配置了客户联系功能的成员列表
     *
     * @return the follow user list
     * @throws WeComException the weComException
     */
    @GET("externalcontact/get_follow_user_list")
    GenericResponse<List<String>> getFollowUserList() throws WeComException;

    /**
     * 配置客户联系「联系我」方式
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/add_contact_way")
    ContactWayAddResponse addContactWay(@Body ContactWayBody request) throws WeComException;

    /**
     * 获取企业已配置的「联系我」方式
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_contact_way")
    GenericResponse<ContactWayBodyDetail> getContactWay(@Body ContactWayConfigRequest request) throws WeComException;

    /**
     * 获取企业已配置的「联系我」列表
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/list_contact_way")
    ContactListResponse listContactWay(@Body ContactListRequest request) throws WeComException;

    /**
     * 更新企业已配置的「联系我」方式
     *
     * @param contactWay the contact way
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/update_contact_way")
    WeComResponse updateContactWay(@Body MutableContactWay contactWay) throws WeComException;

    /**
     * 删除企业已配置的「联系我」方式
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/del_contact_way")
    WeComResponse delContactWay(@Body ContactWayConfigRequest request) throws WeComException;

    /**
     * 结束临时会话
     *
     * @param chatPair the chat pair
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/close_temp_chat")
    WeComResponse closeTempChat(@Body ChatPair chatPair) throws WeComException;
}
