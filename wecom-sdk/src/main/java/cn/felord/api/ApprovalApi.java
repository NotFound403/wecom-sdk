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
import cn.felord.domain.approval.ApprovalApplyRequest;
import cn.felord.domain.approval.ApprovalDetail;
import cn.felord.domain.approval.ApprovalTempAddRequest;
import cn.felord.domain.approval.ApprovalTempUpdateRequest;
import cn.felord.domain.approval.ApprovalTmpDetailResponse;
import cn.felord.domain.approval.OpenApprovalData;
import cn.felord.domain.approval.SpNoListRequest;
import cn.felord.domain.approval.SpNoListResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

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
        return workWeChatApiClient.post(WeComEndpoint.APPROVAL_TEMPLATE_DETAIL, Collections.singletonMap("template_id", templateId), ApprovalTmpDetailResponse.class);
    }

    /**
     * 创建审批模板
     * <p>
     * 仅『审批』系统应用、自建应用和代开发自建应用可调用。
     *
     * @param template the template
     * @return the generic response
     */
    public GenericResponse<String> createTemplate(ApprovalTempAddRequest template) {
        return workWeChatApiClient.post(WeComEndpoint.APPROVAL_TEMPLATE_ADD, template, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 更新审批模板
     * <p>
     * 可调用本接口更新审批模板。更新模板后，管理后台及审批应用内将更新原模板的内容，已配置的审批流程和规则不变。
     * <ul>
     *     <li>仅『审批』系统应用，自建应用和代开发自建应用可调用</li>
     *     <li>所有应用都可以通过本接口更新自己的模板</li>
     *     <li>『审批』系统应用可以修改管理员手动创建的模板</li>
     *     <li>自建应用和代开发自建应用不可通过本接口更新其他应用创建的模板</li>
     * </ul>
     *
     * @param template the template
     * @return the we com response
     */
    public WeComResponse createTemplate(ApprovalTempUpdateRequest template) {
        return workWeChatApiClient.post(WeComEndpoint.APPROVAL_TEMPLATE_UPDATE, template, WeComResponse.class);
    }

    /**
     * 提交审批申请
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> apply(ApprovalApplyRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.APPROVAL_APPLY_EVENT, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 批量获取审批单号
     * <p>
     * 一次拉取调用最多拉取100个审批记录，可以通过多次拉取的方式来满足需求。
     * <ol>
     *     <li>接口频率限制 600次/分钟</li>
     *     <li>请求的参数endtime需要大于startime， 起始时间跨度不能超过31天</li>
     * </ol>
     *
     * @param request the request
     * @return the sp no list response
     */
    public SpNoListResponse queryApprovalInfos(SpNoListRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.APPROVAL_INFO, request, SpNoListResponse.class);
    }

    /**
     * 获取审批申请详情
     *
     * @param spNo the sp no
     * @return sp no list response
     */
    public GenericResponse<ApprovalDetail> queryApprovalDetail(String spNo) {
        return workWeChatApiClient.post(WeComEndpoint.APPROVAL_DETAIL,
                Collections.singletonMap("sp_no", spNo),
                new ParameterizedTypeReference<GenericResponse<ApprovalDetail>>() {
                });
    }

    /**
     * 查询自建应用审批单当前状态
     *
     * @param thirdNo the third no
     * @return the generic response
     */
    public GenericResponse<OpenApprovalData> queryOpenApprovalData(String thirdNo) {
        return workWeChatApiClient.post(WeComEndpoint.OPEN_APPROVAL_DATA,
                Collections.singletonMap("thirdNo", thirdNo),
                new ParameterizedTypeReference<GenericResponse<OpenApprovalData>>() {
                });
    }
}
