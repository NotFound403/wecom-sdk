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
import cn.felord.domain.oa.ScheduleAddRequest;
import cn.felord.domain.oa.ScheduleAttendees;
import cn.felord.domain.oa.ScheduleCalendarQuery;
import cn.felord.domain.oa.ScheduleDelRequest;
import cn.felord.domain.oa.ScheduleDetailRequest;
import cn.felord.domain.oa.ScheduleDetailResponse;
import cn.felord.domain.oa.ScheduleUpdateRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 日程接口
 *
 * @author felord.cn
 * @since 1.0.0
 */
public interface ScheduleApi {

    /**
     * 创建日程
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/schedule/add")
    Single<GenericResponse<String>> add(@Body ScheduleAddRequest request);

    /**
     * 更新日程
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/schedule/update")
    Single<GenericResponse<String>> update(@Body ScheduleUpdateRequest request);

    /**
     * 新增日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    @POST("oa/schedule/add_attendees")
    Single<WeComResponse> addAttendees(@Body ScheduleAttendees attendees);

    /**
     * 删除日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    @POST("oa/schedule/del_attendees")
    Single<WeComResponse> delAttendees(@Body ScheduleAttendees attendees);

    /**
     * 获取日程详情
     *
     * @param request the request
     * @return the schedule detail response
     */
    @POST("oa/schedule/get")
    Single<ScheduleDetailResponse> get(@Body ScheduleDetailRequest request);

    /**
     * 取消日程
     *
     * @param request the request
     * @return the we com response
     */
    @POST("oa/schedule/del")
    Single<WeComResponse> del(@Body ScheduleDelRequest request);

    /**
     * 获取日历下的日程列表
     *
     * @param query the query
     * @return the by calendar
     */
    @POST("oa/schedule/get_by_calendar")
    Single<ScheduleDetailResponse> getByCalendar(@Body ScheduleCalendarQuery query);
}
