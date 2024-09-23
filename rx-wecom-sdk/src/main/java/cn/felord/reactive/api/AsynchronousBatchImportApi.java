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
import cn.felord.domain.contactbook.async.BatchPartyRequest;
import cn.felord.domain.contactbook.async.BatchResultResponse;
import cn.felord.domain.contactbook.async.BatchUserRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 异步导入接口
 *
 * @author n1
 * @since 2021 /6/18 16:25
 */
public interface AsynchronousBatchImportApi {


    /**
     * 增量更新成员
     *
     * @param request the request
     * @return the generic response
     */
    @POST("batch/syncuser")
    Single<GenericResponse<String>> batchSyncUser(@Body BatchUserRequest request);

    /**
     * 全量覆盖成员
     *
     * @param request the request
     * @return the generic response
     */
    @POST("batch/replaceuser")
    Single<GenericResponse<String>> batchSyncReplaceUser(@Body BatchUserRequest request);

    /**
     * 全量覆盖部门
     *
     * @param request the request
     * @return the generic response
     */
    @POST("batch/replaceparty")
    Single<GenericResponse<String>> batchSyncReplaceParty(@Body BatchPartyRequest request);

    /**
     * 获取异步任务结果
     *
     * @param jobId the job id
     * @return the result
     */
    @GET("batch/getresult")
    Single<BatchResultResponse> getResult(@Query("jobid") String jobId);
}
