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
import cn.felord.domain.callcenter.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 客服账号管理
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public interface KfAccountApi {

    /**
     * 添加客服账号
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("kf/account/add")
    GenericResponse<String> addKfAccount(@Body KfAccountAddRequest request) throws WeComException;

    /**
     * 删除客服账号
     *
     * @param openKfid the open kfid
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("kf/account/del")
    WeComResponse delKfAccount(@Body OpenKfid openKfid) throws WeComException;

    /**
     * 修改客服账号
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("kf/account/update")
    WeComResponse updateKfAccount(@Body KfAccountUpdateRequest request) throws WeComException;

    /**
     * 获取客服账号列表
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("kf/account/list")
    GenericResponse<List<KfAccountInfo>> kfAccountList(@Body KfAccountListRequest request) throws WeComException;

    /**
     * 获取客服账号链接
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("kf/add_contact_way")
    GenericResponse<String> addContactWay(@Body KfAccountLinkRequest request) throws WeComException;
}
