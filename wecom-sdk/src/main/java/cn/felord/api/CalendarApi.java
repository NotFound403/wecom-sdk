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
import cn.felord.domain.oa.*;
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
     * @throws WeComException the weComException
     */
    @POST("oa/calendar/add")
    GenericResponse<String> add(@Body CalendarAddRequest request) throws WeComException;

    /**
     * 更新日历
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("oa/calendar/update")
    WeComResponse update(@Body CalendarUpdateRequest request) throws WeComException;

    /**
     * 获取日历详情
     *
     * @param request the request
     * @return the calendar detail response
     * @throws WeComException the weComException
     */
    @POST("oa/calendar/get")
    CalendarDetailResponse get(@Body CalendarDetailRequest request) throws WeComException;

    /**
     * 删除日历
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("oa/calendar/del")
    WeComResponse del(@Body CalendarDelRequest request) throws WeComException;
}
