package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.approval.ApprovalApplyRequest;
import cn.felord.domain.approval.ApprovalTemplate;
import cn.felord.domain.approval.ApprovalTmpDetailResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

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
     * 获取审批模板详情
     *
     * @param templateId the template id
     * @return the detail
     */
    public ApprovalTmpDetailResponse getDetail(String templateId) {
        String endpoint = WeComEndpoint.APPROVAL_TEMPLATE_DETAIL.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("template_id", templateId), ApprovalTmpDetailResponse.class);
    }

    /**
     * 创建审批模板
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

    /**
     * 提交审批申请
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> apply(ApprovalApplyRequest request) {
        String endpoint = WeComEndpoint.APPROVAL_APPLY_EVENT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

}
