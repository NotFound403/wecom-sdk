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
import cn.felord.domain.common.PageRequest;
import cn.felord.domain.common.StrategyId;
import cn.felord.domain.contactbook.user.ExternalUserListDetailRequest;
import cn.felord.domain.externalcontact.*;
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
    GenericResponse<List<String>> listByUserId(@Query("userid") String userId);

    /**
     * 获取客户详情
     *
     * @param externalUserid the external userid
     * @param cursor         the cursor
     * @return the by user id
     */
    @GET("externalcontact/get")
    ExternalUserDetailResponse getByExUserId(@Query("external_userid") String externalUserid, @Query("cursor") String cursor);

    /**
     * 批量获取客户详情
     *
     * @param request the request
     * @return the by user id
     */
    @POST("externalcontact/batch/get_by_user")
    ExternalUserListDetailResponse batchByUserIds(@Body ExternalUserListDetailRequest request);

    /**
     * 修改客户备注信息
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/remark")
    WeComResponse remark(@Body CustomerRemarkRequest request);

    /**
     * 获取规则组列表
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/customer_strategy/list")
    StrategyListResponse customerStrategyList(@Body PageRequest request);

    /**
     * 获取规则组详情
     *
     * @param strategyId the strategy id
     * @return the external user list detail response
     */
    @POST("externalcontact/customer_strategy/get")
    CustomerStrategyDetailResponse getCustomerStrategy(@Body StrategyId strategyId);

    /**
     * 获取规则组管理范围
     *
     * @param request the request
     * @return the external user list detail response
     */
    @POST("externalcontact/customer_strategy/get_range")
    StrategyRangeResponse getCustomerStrategyRange(@Body StrategyRangeRequest request);

    /**
     * 创建新的规则组
     *
     * @param request the request
     * @return the customer strategy range response
     */
    @POST("externalcontact/customer_strategy/create")
    GenericResponse<Integer> createCustomerStrategy(@Body CustomerStrategyRequest request);

    /**
     * 编辑规则组及其管理范围
     *
     * @param request the request
     * @return the customer strategy range response
     */
    @POST("externalcontact/customer_strategy/edit")
    WeComResponse editCustomerStrategy(@Body MutableCustomerStrategy request);


    /**
     * 删除规则组
     *
     * @param strategyId the strategy id
     * @return the customer strategy range response
     */
    @POST("externalcontact/customer_strategy/del")
    WeComResponse delCustomerStrategy(@Body StrategyId strategyId);

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
    GenericResponse<String> convertToOpenid(@Body ExternalUserId externalUserId);
}
