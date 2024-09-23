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

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.StrategyId;
import cn.felord.domain.contactbook.user.ExternalUserListDetailRequest;
import cn.felord.domain.externalcontact.*;
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
    Single<StrategyRangeResponse> getCustomerStrategyRange(@Body StrategyRangeRequest request);

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

    /**
     * 获取已服务的外部联系人
     * <p>
     * 企业可通过此接口获取所有已服务的外部联系人，及其添加人和加入的群聊。
     * 外部联系人分为客户和其他外部联系人，如果是客户，接口将返回外部联系人临时ID和externaluserid；
     * 如果是其他外部联系人，接口将只返回外部联系人临时ID。
     * <p>
     * 企业可通过外部联系人临时ID排除重复数据，外部联系人临时ID有效期为4小时。
     *
     * @param request cursor具有有效期，请勿缓存后使用
     * @return generic response
     * @throws WeComException the we com exception
     */
    @POST("externalcontact/contact_list")
    Single<ContractListResponse> contactList(@Body PageRequest request);
}
