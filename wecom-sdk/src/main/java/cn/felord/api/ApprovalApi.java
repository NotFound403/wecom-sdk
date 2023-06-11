/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.approval.*;
import cn.felord.domain.common.TemplateId;
import cn.felord.domain.oa.ApprovalSpNo;
import cn.felord.domain.oa.ApprovalThirdNo;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 企业微信审批
 *
 * @author dax
 * @since 2023 /5/25 14:18
 */
public interface ApprovalApi {

    /**
     * 获取审批模板详情
     *
     * @param templateId the template id
     * @return the detail
     */
    @POST("oa/gettemplatedetail")
    ApprovalTmpDetailResponse getDetail(@Body TemplateId templateId);

    /**
     * 创建审批模板
     * <p>
     * 仅『审批』系统应用、自建应用和代开发自建应用可调用。
     *
     * @param template the template
     * @return the generic response
     */
    @POST("oa/approval/create_template")
    GenericResponse<String> createTemplate(@Body ApprovalTempAddRequest template);

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
    @POST("oa/approval/update_template")
    WeComResponse createTemplate(@Body ApprovalTempUpdateRequest template);

    /**
     * 提交审批申请
     *
     * @param request the request
     * @return the generic response
     */
    @POST("oa/applyevent")
    GenericResponse<String> apply(@Body ApprovalApplyRequest request);

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
    @POST("oa/getapprovalinfo")
    SpNoListResponse queryApprovalInfos(@Body SpNoListRequest request);

    /**
     * 获取审批申请详情
     * sp_no
     *
     * @param spNo the sp no
     * @return sp no list response
     */
    @POST("oa/getapprovaldetail")
    GenericResponse<ApprovalDetail> queryApprovalDetail(@Body ApprovalSpNo spNo);

    /**
     * 查询自建应用审批单当前状态
     *
     * @param thirdNo the third no thirdNo
     * @return the generic response
     */
    @POST("corp/getopenapprovaldata")
    GenericResponse<OpenApprovalData> queryOpenApprovalData(@Body ApprovalThirdNo thirdNo);
}
