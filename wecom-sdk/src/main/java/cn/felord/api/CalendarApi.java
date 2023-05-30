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
import cn.felord.domain.oa.CalendarAddRequest;
import cn.felord.domain.oa.CalendarDetailResponse;
import cn.felord.domain.oa.CalendarUpdateRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;
import java.util.Set;

/**
 * 日历接口
 *
 * @author felord
 * @since 2021 /10/17 17:48
 */
public class CalendarApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Calendar api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    CalendarApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建日历
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> add(CalendarAddRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OA_CALENDAR_ADD, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新日历
     *
     * @param request the request
     * @return the generic response
     */
    public WeComResponse update(CalendarUpdateRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.OA_CALENDAR_UPDATE, request, WeComResponse.class);
    }

    /**
     * 获取日历详情
     *
     * @param calIdList the cal id list
     * @return the calendar detail response
     */
    public CalendarDetailResponse get(Set<String> calIdList) {
        return workWeChatApiClient.post(WeComEndpoint.OA_CALENDAR_GET, Collections.singletonMap("cal_id_list", calIdList), CalendarDetailResponse.class);
    }

    /**
     * 删除日历
     *
     * @param calId the cal id
     * @return the we com response
     */
    public WeComResponse del(String calId) {
        return workWeChatApiClient.post(WeComEndpoint.OA_CALENDAR_DEL, Collections.singletonMap("cal_id", calId), WeComResponse.class);
    }
}
