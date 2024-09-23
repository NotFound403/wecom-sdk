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

import cn.felord.domain.callcenter.KfServicerListResponse;
import cn.felord.domain.callcenter.KfServicerRequest;
import cn.felord.domain.callcenter.KfServicerResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 接待人员管理
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public interface KfServicerApi {

    /**
     * 添加接待人员
     *
     * @param request the request
     * @return the generic response
     */
    @POST("kf/servicer/add")
    Single<KfServicerResponse> addKfServicer(@Body KfServicerRequest request);

    /**
     * 删除接待人员
     *
     * @param request the request
     * @return the we com response
     */
    @POST("kf/servicer/del")
    Single<KfServicerResponse> delKfServicer(@Body KfServicerRequest request);

    /**
     * 获取接待人员列表
     *
     * @param openKfid the openKfid
     * @return the generic response
     */
    @GET("kf/servicer/list")
    Single<KfServicerListResponse> kfServicerList(@Query("open_kfid") String openKfid);
}
