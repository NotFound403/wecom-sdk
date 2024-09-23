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
import cn.felord.domain.oa.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 日历接口
 *
 * @author felord
 * @since 2021 /10/17 17:48
 */
public interface CalendarApi {

    /**
     * 创建日历
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/calendar/add")
    Single<GenericResponse<String>> add(@Body CalendarAddRequest request);

    /**
     * 更新日历
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/calendar/update")
    Single<WeComResponse> update(@Body CalendarUpdateRequest request);

    /**
     * 获取日历详情
     *
     * @param request the request
     * @return the calendar detail response
     */
    @POST("oa/calendar/get")
    Single<CalendarDetailResponse> get(@Body CalendarDetailRequest request);

    /**
     * 删除日历
     *
     * @param request the request
     * @return the we com response
     */
    @POST("oa/calendar/del")
    Single<WeComResponse> del(@Body CalendarDelRequest request);
}
