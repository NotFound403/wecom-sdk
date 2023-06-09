package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.MomentId;
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
     * @param <T>  the type parameter
     * @param body the body
     * @return the generic response
     */
    @POST("externalcontact/add_moment_task")
    <T extends MomentAttachment> Single<GenericResponse<String>> addMomentTask(@Body MomentBody<T> body);

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
    Single<WeComResponse> editMomentStrategy(MutableMomentStrategy request);

    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     */
    @POST("externalcontact/moment_strategy/del")
    Single<WeComResponse> delMomentStrategy(StrategyId strategyId);
}
