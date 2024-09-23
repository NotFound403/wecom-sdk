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

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.MomentId;
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.StrategyId;
import cn.felord.domain.common.UserMoment;
import cn.felord.domain.externalcontact.*;
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
     * @throws WeComException the weComException
     */
    @POST("externalcontact/add_moment_task")
    GenericResponse<String> addMomentTask(@Body MomentBody<MomentAttachment> body) throws WeComException;

    /**
     * 获取任务创建结果
     *
     * @param jobId the job id
     * @return the moment task result response
     * @throws WeComException the weComException
     */
    @GET("externalcontact/get_moment_task_result")
    MomentTaskResultResponse getMomentTaskResult(@Query("jobid") String jobId) throws WeComException;

    /**
     * 获取企业全部的发表列表
     *
     * @param request the request
     * @return the moment list
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_moment_list")
    MomentListResponse getMomentList(@Body MomentListRequest request) throws WeComException;

    /**
     * 获取客户朋友圈企业发表的列表
     *
     * @param request the request
     * @return the moment list
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_moment_task")
    MomentMemberTaskResponse getMomentTask(@Body MomentTaskRequest request) throws WeComException;

    /**
     * 获取客户朋友圈发表时选择的可见范围
     * <p>
     * 指用户发表时指定了哪些客户可收
     *
     * @param request the request
     * @return the moment customer list
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_moment_customer_list")
    MomentCustomerListResponse getMomentCustomerList(@Body MomentInfoRequest request) throws WeComException;

    /**
     * 获取客户朋友圈发表后的可见客户列表
     * <p>
     * 指哪些客户真正可以看到
     *
     * @param request the request
     * @return the moment send result
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_moment_send_result")
    MomentCustomerListResponse getMomentSendResult(@Body MomentInfoRequest request) throws WeComException;

    /**
     * 停止发表企业朋友圈
     *
     * @param momentId the moment id
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/cancel_moment_task")
    WeComResponse cancelMomentTask(@Body MomentId momentId) throws WeComException;

    /**
     * 获取客户朋友圈的互动数据
     * <p>
     * 优化了企业微信给的数据结构
     *
     * @param userId the user id
     * @return the moment 优化了企业微信给的数据结构
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_moment_comments")
    MomentCommentResponse getMomentComments(@Body UserMoment userId) throws WeComException;

    /**
     * 获取规则组列表
     *
     * @param request the request
     * @return the external user list detail response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/moment_strategy/list")
    StrategyListResponse momentStrategyList(@Body PageRequest request) throws WeComException;

    /**
     * 获取规则组详情
     *
     * @param strategyId the strategy id
     * @return the external user list detail response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/moment_strategy/get")
    MomentStrategyDetailResponse getMomentStrategy(@Body StrategyId strategyId) throws WeComException;

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/moment_strategy/get_range")
    StrategyRangeResponse getMomentStrategyRange(@Body StrategyRangeRequest request) throws WeComException;

    /**
     * 创建新的规则组
     *
     * @param request the request
     * @return the customer strategy range response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/moment_strategy/create")
    GenericResponse<Integer> createMomentStrategy(@Body CustomerStrategyRequest request) throws WeComException;

    /**
     * 编辑规则组及其管理范围
     *
     * @param request the request
     * @return the customer strategy range response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/moment_strategy/edit")
    WeComResponse editMomentStrategy(@Body MutableMomentStrategy request) throws WeComException;

    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/moment_strategy/del")
    WeComResponse delMomentStrategy(@Body StrategyId strategyId) throws WeComException;
}
