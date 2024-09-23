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

package cn.felord.reactive.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.*;
import io.reactivex.rxjava3.core.Single;
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
     */
    @POST("kf/account/add")
    Single<GenericResponse<String>> addKfAccount(@Body KfAccountAddRequest request);

    /**
     * 删除客服账号
     *
     * @param openKfid the open kfid
     * @return the we com response
     */
    @POST("kf/account/del")
    Single<WeComResponse> delKfAccount(@Body OpenKfid openKfid);

    /**
     * 修改客服账号
     *
     * @param request the request
     * @return the we com response
     */
    @POST("kf/account/update")
    Single<WeComResponse> updateKfAccount(@Body KfAccountUpdateRequest request);

    /**
     * 获取客服账号列表
     *
     * @param request the request
     * @return the generic response
     */
    @POST("kf/account/list")
    Single<GenericResponse<List<KfAccountInfo>>> kfAccountList(@Body KfAccountListRequest request);

    /**
     * 获取客服账号链接
     *
     * @param request the request
     * @return the generic response
     */
    @POST("kf/add_contact_way")
    Single<GenericResponse<String>> addContactWay(@Body KfAccountLinkRequest request);
}
