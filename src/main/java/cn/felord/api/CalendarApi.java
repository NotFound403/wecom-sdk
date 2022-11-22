package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.oa.CalendarAddRequest;
import cn.felord.domain.oa.CalendarDetailResponse;
import cn.felord.domain.oa.CalendarUpdateRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * 日历接口
 *
 * @author felord
 * @since 2022 /10/17 17:48
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
        String endpoint = WeComEndpoint.OA_CALENDAR_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新日历
     *
     * @param request the request
     * @return the generic response
     */
    public WeComResponse update(CalendarUpdateRequest request) {
        String endpoint = WeComEndpoint.OA_CALENDAR_UPDATE.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, WeComResponse.class);
    }

    /**
     * 获取日历详情
     *
     * @param calIdList the cal id list
     * @return the calendar detail response
     */
    public CalendarDetailResponse get(Set<String> calIdList) {
        String endpoint = WeComEndpoint.OA_CALENDAR_GET.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("cal_id_list", calIdList), CalendarDetailResponse.class);
    }

    /**
     * 删除日历
     *
     * @param calId the cal id
     * @return the we com response
     */
    public WeComResponse del(String calId) {
        String endpoint = WeComEndpoint.OA_CALENDAR_DEL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("cal_id", calId), WeComResponse.class);
    }
}
