package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.oa.ScheduleAddRequest;
import cn.felord.domain.oa.ScheduleAttendees;
import cn.felord.domain.oa.ScheduleUpdateRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * 效率工具
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
        String endpoint = WeComEndpoint.OA_SCHEDULE_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新日程
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> update(ScheduleUpdateRequest request) {
        String endpoint = WeComEndpoint.OA_SCHEDULE_UPDATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 新增日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    public WeComResponse addAttendees(ScheduleAttendees attendees) {
        String endpoint = WeComEndpoint.OA_SCHEDULE_ADD_ATTENDEES.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, attendees, WeComResponse.class);
    }

    /**
     * 删除日程参与者
     *
     * @param attendees the attendees
     * @return the we com response
     */
    public WeComResponse delAttendees(ScheduleAttendees attendees) {
        String endpoint = WeComEndpoint.OA_SCHEDULE_DEL_ATTENDEES.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, attendees, WeComResponse.class);
    }

    public WeComResponse get(Set<String> scheduleIds) {
        String endpoint = WeComEndpoint.OA_SCHEDULE_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("schedule_id_list", scheduleIds), WeComResponse.class);
    }


}
