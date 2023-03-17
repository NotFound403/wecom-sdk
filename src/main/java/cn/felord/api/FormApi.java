package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.office.form.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 收集表
 *
 * @author dax
 * @since 2023 /3/13 16:27
 */
public class FormApi {

    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Form api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    FormApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建收集表
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> createForm(CreateFormRequest request) {
        String endpoint = WeComEndpoint.WEDOC_CREATE_FORM.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 编辑收集表信息
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends AbstractUpdateFormRequest> GenericResponse<FormDetail> modifyForm(R request) {
        String endpoint = WeComEndpoint.WEDOC_MODIFY_FORM.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<FormDetail>>() {
        });
    }

    /**
     * 获取收集表信息
     *
     * @param formid the formid
     * @return the form
     */
    public GenericResponse<FormDetail> getForm(String formid) {
        String endpoint = WeComEndpoint.WEDOC_GET_FORM.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        return workWeChatApiClient.post(uri, Collections.singletonMap("formid", formid), new ParameterizedTypeReference<GenericResponse<FormDetail>>() {
        });
    }

    /**
     * 收集表的统计信息查询（仅获取统计结果）
     *
     * @param repeatedId the repeated id
     * @return the form statistic response
     */
    public FormStatisticResponse getFormStatistic(String repeatedId) {
        String endpoint = WeComEndpoint.WEDOC_FORM_STATISTIC.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        Map<String, Object> request = new HashMap<>();
        request.put("repeated_id", repeatedId);
        request.put("req_type", 1);
        return workWeChatApiClient.post(uri, request, FormStatisticResponse.class);
    }

    /**
     * 收集表的统计信息查询（获取已提交列表）
     *
     * @param request the request
     * @return the form statistic response
     */
    public FormConfirmedResponse getFormStatistic(FormConfirmedRequest request) {
        String endpoint = WeComEndpoint.WEDOC_FORM_STATISTIC.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        return workWeChatApiClient.post(uri, request, FormConfirmedResponse.class);
    }

    /**
     * 收集表的统计信息查询（获取未提交列表，仅当限制提交范围时有结果）
     *
     * @param request the request
     * @return the form statistic
     */
    public FormUnConfirmedResponse getFormStatistic(FormUnConfirmedRequest request) {
        String endpoint = WeComEndpoint.WEDOC_FORM_STATISTIC.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        return workWeChatApiClient.post(uri, request, FormUnConfirmedResponse.class);
    }

    /**
     * 读取收集表答案
     *
     * @param request the request
     * @return the form answer response
     */
    public FormAnswerResponse getFormAnswer(FormAnswerRequest request) {
        String endpoint = WeComEndpoint.WEDOC_FORM_ANSWER.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        return workWeChatApiClient.post(uri, request, FormAnswerResponse.class);
    }

}
