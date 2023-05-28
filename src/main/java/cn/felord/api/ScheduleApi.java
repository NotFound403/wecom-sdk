/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.oa.ScheduleAddRequest;
import cn.felord.domain.oa.ScheduleAttendees;
import cn.felord.domain.oa.ScheduleCalendarQuery;
import cn.felord.domain.oa.ScheduleDelRequest;
import cn.felord.domain.oa.ScheduleDetailResponse;
import cn.felord.domain.oa.ScheduleUpdateRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;
import java.util.Set;

/**
 * 日程接口
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public class ScheduleApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Schedule api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ScheduleApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建日程
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> add(ScheduleAddRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OA_SCHEDULE_ADD, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新日程
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> update(ScheduleUpdateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OA_SCHEDULE_UPDATE, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 新增日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    public WeComResponse addAttendees(ScheduleAttendees attendees) {
        return workWeChatApiClient.post(WeComEndpoint.OA_SCHEDULE_ADD_ATTENDEES, attendees, WeComResponse.class);
    }

    /**
     * 删除日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    public WeComResponse delAttendees(ScheduleAttendees attendees) {
        return workWeChatApiClient.post(WeComEndpoint.OA_SCHEDULE_DEL_ATTENDEES, attendees, WeComResponse.class);
    }

    /**
     * 获取日程详情
     *
     * @param scheduleIds the schedule ids
     * @return the schedule detail response
     */
    public ScheduleDetailResponse get(Set<String> scheduleIds) {
        return workWeChatApiClient.post(WeComEndpoint.OA_SCHEDULE_GET, Collections.singletonMap("schedule_id_list", scheduleIds), ScheduleDetailResponse.class);
    }


    /**
     * 取消日程
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse del(ScheduleDelRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OA_SCHEDULE_DEL, request, WeComResponse.class);
    }

    /**
     * 获取日历下的日程列表
     *
     * @param query the query
     * @return the by calendar
     */
    public ScheduleDetailResponse getByCalendar(ScheduleCalendarQuery query) {
        return workWeChatApiClient.post(WeComEndpoint.OA_SCHEDULE_BY_CALENDAR, query, ScheduleDetailResponse.class);
    }
}
