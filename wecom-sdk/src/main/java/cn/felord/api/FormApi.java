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
import cn.felord.domain.wedoc.form.AbstractUpdateFormRequest;
import cn.felord.domain.wedoc.form.CreateFormRequest;
import cn.felord.domain.wedoc.form.FormAnswerRequest;
import cn.felord.domain.wedoc.form.FormAnswerResponse;
import cn.felord.domain.wedoc.form.FormConfirmedRequest;
import cn.felord.domain.wedoc.form.FormConfirmedResponse;
import cn.felord.domain.wedoc.form.FormDetail;
import cn.felord.domain.wedoc.form.FormStatisticResponse;
import cn.felord.domain.wedoc.form.FormUnConfirmedRequest;
import cn.felord.domain.wedoc.form.FormUnConfirmedResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

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
        return workWeChatApiClient.post(WeComEndpoint.WEDOC_CREATE_FORM, request, new ParameterizedTypeReference<GenericResponse<String>>() {
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
        return workWeChatApiClient.post(WeComEndpoint.WEDOC_MODIFY_FORM, request, new ParameterizedTypeReference<GenericResponse<FormDetail>>() {
        });
    }

    /**
     * 获取收集表信息
     *
     * @param formid the formid
     * @return the form
     */
    public GenericResponse<FormDetail> getForm(String formid) {
        return workWeChatApiClient.post(WeComEndpoint.WEDOC_GET_FORM, Collections.singletonMap("formid", formid), new ParameterizedTypeReference<GenericResponse<FormDetail>>() {
        });
    }

    /**
     * 收集表的统计信息查询（仅获取统计结果）
     *
     * @param repeatedId the repeated id
     * @return the form statistic response
     */
    public FormStatisticResponse getFormStatistic(String repeatedId) {
        Map<String, Object> request = new HashMap<>();
        request.put("repeated_id", repeatedId);
        request.put("req_type", 1);
        return workWeChatApiClient.post(WeComEndpoint.WEDOC_FORM_STATISTIC, request, FormStatisticResponse.class);
    }

    /**
     * 收集表的统计信息查询（获取已提交列表）
     *
     * @param request the request
     * @return the form statistic response
     */
    public FormConfirmedResponse getFormStatistic(FormConfirmedRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.WEDOC_FORM_STATISTIC, request, FormConfirmedResponse.class);
    }

    /**
     * 收集表的统计信息查询（获取未提交列表，仅当限制提交范围时有结果）
     *
     * @param request the request
     * @return the form statistic
     */
    public FormUnConfirmedResponse getFormStatistic(FormUnConfirmedRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.WEDOC_FORM_STATISTIC, request, FormUnConfirmedResponse.class);
    }

    /**
     * 读取收集表答案
     *
     * @param request the request
     * @return the form answer response
     */
    public FormAnswerResponse getFormAnswer(FormAnswerRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.WEDOC_FORM_ANSWER, request, FormAnswerResponse.class);
    }

}
