/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.reactive.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.MomentId;
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.StrategyId;
import cn.felord.domain.common.UserMoment;
import cn.felord.domain.externalcontact.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 客户朋友圈
 *
 * @author dax
 * @since 2021 /8/19 14:45
 */
public interface MomentApi {

    /**
     * 创建发表任务
     *
     * @param body the body
     * @return the generic response
     */
    @POST("externalcontact/add_moment_task")
    Single<GenericResponse<String>> addMomentTask(@Body MomentBody<MomentAttachment> body);

    /**
     * 获取任务创建结果
     *
     * @param jobId the job id
     * @return the moment task result response
     */
    @GET("externalcontact/get_moment_task_result")
    Single<MomentTaskResultResponse> getMomentTaskResult(@Query("jobid") String jobId);

    /**
     * 获取企业全部的发表列表
     *
     * @param request the request
     * @return the moment list
     */
    @POST("externalcontact/get_moment_list")
    Single<MomentListResponse> getMomentList(@Body MomentListRequest request);

    /**
     * 获取客户朋友圈企业发表的列表
     *
     * @param request the request
     * @return the moment list
     */
    @POST("externalcontact/get_moment_task")
    Single<MomentMemberTaskResponse> getMomentTask(@Body MomentTaskRequest request);

    /**
     * 获取客户朋友圈发表时选择的可见范围
     * <p>
     * 指用户发表时指定了哪些客户可收
     *
     * @param request the request
     * @return the moment customer list
     */
    @POST("externalcontact/get_moment_customer_list")
    Single<MomentCustomerListResponse> getMomentCustomerList(@Body MomentInfoRequest request);

    /**
     * 获取客户朋友圈发表后的可见客户列表
     * <p>
     * 指哪些客户真正可以看到
     *
     * @param request the request
     * @return the moment send result
     */
    @POST("externalcontact/get_moment_send_result")
    Single<MomentCustomerListResponse> getMomentSendResult(@Body MomentInfoRequest request);

    /**
     * 停止发表企业朋友圈
     *
     * @param momentId the moment id
     * @return the we com response
     */
    @POST("externalcontact/cancel_moment_task")
    Single<WeComResponse> cancelMomentTask(@Body MomentId momentId);

    /**
     * 获取客户朋友圈的互动数据
     * <p>
     * 优化了企业微信给的数据结构
     *
     * @param userId the user id
     * @return the moment 优化了企业微信给的数据结构
     */
    @POST("externalcontact/get_moment_comments")
    Single<MomentCommentResponse> getMomentComments(@Body UserMoment userId);

    /**
     * 获取规则组列表
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/moment_strategy/list")
    Single<StrategyListResponse> momentStrategyList(@Body PageRequest request);

    /**
     * 获取规则组详情
     *
     * @param strategyId the strategy id
     * @return the external user list detail response
     */
    @POST("externalcontact/moment_strategy/get")
    Single<MomentStrategyDetailResponse> getMomentStrategy(@Body StrategyId strategyId);

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/moment_strategy/get_range")
    Single<StrategyRangeResponse> getMomentStrategyRange(@Body StrategyRangeRequest request);

    /**
     * 创建新的规则组
     *
     * @param request the request
     * @return the customer strategy range response
     */
    @POST("externalcontact/moment_strategy/create")
    Single<GenericResponse<Integer>> createMomentStrategy(@Body CustomerStrategyRequest request);

    /**
     * 编辑规则组及其管理范围
     *
     * @param request the request
     * @return the customer strategy range response
     */
    @POST("externalcontact/moment_strategy/edit")
    Single<WeComResponse> editMomentStrategy(@Body MutableMomentStrategy request);

    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     */
    @POST("externalcontact/moment_strategy/del")
    Single<WeComResponse> delMomentStrategy(@Body StrategyId strategyId);
}
