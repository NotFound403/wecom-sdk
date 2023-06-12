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
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.StrategyId;
import cn.felord.domain.common.UserMoment;
import cn.felord.domain.externalcontact.CustomerStrategyRequest;
import cn.felord.domain.externalcontact.MomentAttachment;
import cn.felord.domain.externalcontact.MomentBody;
import cn.felord.domain.externalcontact.MomentCommentResponse;
import cn.felord.domain.externalcontact.MomentCustomerListResponse;
import cn.felord.domain.externalcontact.MomentInfoRequest;
import cn.felord.domain.externalcontact.MomentListRequest;
import cn.felord.domain.externalcontact.MomentListResponse;
import cn.felord.domain.externalcontact.MomentMemberTaskResponse;
import cn.felord.domain.externalcontact.MomentStrategyDetailResponse;
import cn.felord.domain.externalcontact.MomentTaskRequest;
import cn.felord.domain.externalcontact.MomentTaskResultResponse;
import cn.felord.domain.externalcontact.MutableMomentStrategy;
import cn.felord.domain.externalcontact.StrategyListResponse;
import cn.felord.domain.externalcontact.StrategyRangeRequest;
import cn.felord.domain.externalcontact.StrategyRangeResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Collections;

/**
 * 客户朋友圈
 *
 * @author dax
 * @since 2021 /8/19 14:45
 */
public class MomentApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Moment api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    MomentApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 创建发表任务
     *
     * @param <T>  the type parameter
     * @param body the body
     * @return the generic response
     */
    public <T extends MomentAttachment> GenericResponse<String> addMomentTask(MomentBody<T> body) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_TASK_ADD, body, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * 获取任务创建结果
     *
     * @param jobId the job id
     * @return the moment task result response
     */
    public MomentTaskResultResponse getMomentTaskResult(String jobId) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("jobid", jobId);
        return workWeChatApiClient.get(WeComEndpoint.MOMENT_TASK_JOB_RESULT, query, MomentTaskResultResponse.class);
    }

    /**
     * 获取企业全部的发表列表
     *
     * @param request the request
     * @return the moment list
     */
    public MomentListResponse getMomentList(MomentListRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_LIST, request, MomentListResponse.class);
    }

    /**
     * 获取客户朋友圈企业发表的列表
     *
     * @param request the request
     * @return the moment list
     */
    public MomentMemberTaskResponse getMomentTask(MomentTaskRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_TASK_GET, request, MomentMemberTaskResponse.class);
    }

    /**
     * 获取客户朋友圈发表时选择的可见范围
     * <p>
     * 指用户发表时指定了哪些客户可收
     *
     * @param request the request
     * @return the moment customer list
     */
    public MomentCustomerListResponse getMomentCustomerList(MomentInfoRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_CUSTOMER_LIST, request, MomentCustomerListResponse.class);
    }

    /**
     * 获取客户朋友圈发表后的可见客户列表
     * <p>
     * 指哪些客户真正可以看到
     *
     * @param request the request
     * @return the moment send result
     */
    public MomentCustomerListResponse getMomentSendResult(MomentInfoRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_SEND_RESULT, request, MomentCustomerListResponse.class);
    }

    /**
     * 停止发表企业朋友圈
     *
     * @param momentId the moment id
     * @return the we com response
     */
    public WeComResponse cancelMomentTask(String momentId) {
        return workWeChatApiClient.post(WeComEndpoint.CANCEL_MOMENT_TASK, Collections.singletonMap("moment_id", momentId), WeComResponse.class);
    }

    /**
     * 获取客户朋友圈的互动数据
     * <p>
     * 优化了企业微信给的数据结构
     *
     * @param momentId the moment id
     * @param userId   the user id
     * @return the moment 优化了企业微信给的数据结构
     */
    public MomentCommentResponse getMomentComments(String momentId, String userId) {
        UserMoment userMoment = new UserMoment(momentId, userId);
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_COMMENTS, userMoment, MomentCommentResponse.class);
    }

    /**
     * 获取规则组列表
     *
     * @param cursor the cursor
     * @param limit  the limit
     * @return the external user list detail response
     */
    public StrategyListResponse momentStrategyList(String cursor, int limit) {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setCursor(cursor);
        pageRequest.setLimit(limit);
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_STRATEGY_LIST, pageRequest, StrategyListResponse.class);
    }

    /**
     * 获取规则组详情
     *
     * @param strategyId the strategy id
     * @return the external user list detail response
     */
    public MomentStrategyDetailResponse getMomentStrategy(int strategyId) {
        StrategyId body = new StrategyId(strategyId);
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_STRATEGY_GET,
                body,
                MomentStrategyDetailResponse.class);
    }

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     */
    public StrategyRangeResponse getMomentStrategyRange(StrategyRangeRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_STRATEGY_RANGE, request, StrategyRangeResponse.class);
    }

    /**
     * 创建新的规则组
     *
     * @param request the request
     * @return the customer strategy range response
     */
    public GenericResponse<Integer> createMomentStrategy(CustomerStrategyRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_STRATEGY_CREATE, request, new ParameterizedTypeReference<GenericResponse<Integer>>() {
        });
    }

    /**
     * 编辑规则组及其管理范围
     *
     * @param request the request
     * @return the customer strategy range response
     */
    public WeComResponse editMomentStrategy(MutableMomentStrategy request) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_STRATEGY_EDIT, request, WeComResponse.class);
    }

    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     */
    public WeComResponse delMomentStrategy(int strategyId) {
        return workWeChatApiClient.post(WeComEndpoint.MOMENT_STRATEGY_DEL, Collections.singletonMap("strategy_id", strategyId), WeComResponse.class);
    }
}
