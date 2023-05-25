package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.approval.ApprovalApplyRequest;
import cn.felord.domain.approval.ApprovalTemplate;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 审批
 *
 * @author dax
 * @since 2023 /5/25 14:18
 */
public class ApprovalApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Calendar api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    ApprovalApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * Create template generic response.
     *
     * @param template the template
     * @return the generic response
     */
    public GenericResponse<String> createTemplate(ApprovalTemplate template) {
        String endpoint = WeComEndpoint.APPROVAL_TEMPLATE_ADD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, template, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    public GenericResponse<String> apply(ApprovalApplyRequest request){
        String endpoint = WeComEndpoint.APPROVAL_APPLY_EVENT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

}
