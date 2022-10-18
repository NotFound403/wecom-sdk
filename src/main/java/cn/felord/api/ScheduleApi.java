package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.oa.ScheduleAddRequest;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
    public GenericResponse<String> add(ScheduleAddRequest request){
        String endpoint = WeComEndpoint.OA_SCHEDULE_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

}
