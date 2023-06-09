package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.StrategyId;
import cn.felord.domain.contactbook.user.ExternalUserListDetailRequest;
import cn.felord.domain.externalcontact.CustomerRemarkRequest;
import cn.felord.domain.externalcontact.CustomerStrategyDetailResponse;
import cn.felord.domain.externalcontact.CustomerStrategyRequest;
import cn.felord.domain.externalcontact.ExternalUserDetailResponse;
import cn.felord.domain.externalcontact.ExternalUserId;
import cn.felord.domain.externalcontact.ExternalUserListDetailResponse;
import cn.felord.domain.externalcontact.MutableCustomerStrategy;
import cn.felord.domain.externalcontact.StrategyListResponse;
import cn.felord.domain.externalcontact.StrategyRangeRequest;
import cn.felord.domain.externalcontact.StrategyRangeResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * 客户管理
 *
 * @author dax
 * @since 2021 /9/8 19:05
 */
public interface ExternalContactUserApi {

    /**
     * 获取客户列表
     *
     * @param userId the user id
     * @return the follow user list
     */
    @GET("externalcontact/list")
    Single<GenericResponse<List<String>>> listByUserId(@Query("userid") String userId);

    /**
     * 获取客户详情
     *
     * @param externalUserid the external userid
     * @param cursor         the cursor
     * @return the by user id
     */
    @GET("externalcontact/get")
    Single<ExternalUserDetailResponse> getByExUserId(@Query("external_userid") String externalUserid, @Query("cursor") String cursor);

    /**
     * 批量获取客户详情
     *
     * @param request the request
     * @return the by user id
     */
    @POST("externalcontact/batch/get_by_user")
    Single<ExternalUserListDetailResponse> batchByUserIds(@Body ExternalUserListDetailRequest request);

    /**
     * 修改客户备注信息
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/remark")
    Single<WeComResponse> remark(@Body CustomerRemarkRequest request);

    /**
     * 获取规则组列表
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/customer_strategy/list")
    Single<StrategyListResponse> customerStrategyList(@Body PageRequest request);

    /**
     * 获取规则组详情
     *
     * @param strategyId the strategy id
     * @return the external user list detail response
     */
    @POST("externalcontact/customer_strategy/get")
    Single<CustomerStrategyDetailResponse> getCustomerStrategy(@Body StrategyId strategyId);

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/customer_strategy/get_range")
    Single<StrategyRangeResponse> getCustomerStrategyRange(StrategyRangeRequest request);

    /**
     * 创建新的规则组
     *
     * @param request the request
     * @return the customer strategy range response
     */
    @POST("externalcontact/customer_strategy/create")
    Single<GenericResponse<Integer>> createCustomerStrategy(@Body CustomerStrategyRequest request);

    /**
     * 编辑规则组及其管理范围
     *
     * @param request the request
     * @return the customer strategy range response
     */
    @POST("externalcontact/customer_strategy/edit")
    Single<WeComResponse> editCustomerStrategy(@Body MutableCustomerStrategy request);


    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     */
    @POST("externalcontact/customer_strategy/del")
    Single<WeComResponse> delCustomerStrategy(@Body StrategyId strategyId);

    /**
     * 家校沟通-外部联系人openid转换
     * <p>
     * 企业和服务商可通过此接口，将微信外部联系人的userid（如何获取?）转为微信openid，用于调用支付相关接口。
     * 暂不支持企业微信外部联系人（ExternalUserid为wo开头）的userid转openid。
     *
     * @param externalUserId the external user id
     * @return the generic response
     */
    @POST("externalcontact/convert_to_openid")
    Single<GenericResponse<String>> convertToOpenid(@Body ExternalUserId externalUserId);
}
