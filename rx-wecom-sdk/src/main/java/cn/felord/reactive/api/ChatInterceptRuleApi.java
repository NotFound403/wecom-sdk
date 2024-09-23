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
import cn.felord.domain.externalcontact.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 管理聊天敏感词
 *
 * @author dax
 * @since 2021 /8/17 10:26
 */
public interface ChatInterceptRuleApi {

    /**
     * 新建敏感词规则
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/add_intercept_rule")
    Single<GenericResponse<String>> addInterceptRule(@Body ChatInterceptRuleAddRequest request);

    /**
     * 获取敏感词规则列表
     *
     * @return the generic response
     */
    @GET("externalcontact/get_intercept_rule_list")
    Single<GenericResponse<InterceptRuleInfo>> interceptRuleList();

    /**
     * 获取敏感词规则详情
     *
     * @param request the request
     * @return the intercept rule
     */
    @POST("externalcontact/get_intercept_rule")
    Single<GenericResponse<InterceptRuleDetail>> getInterceptRule(@Body InterceptRuleRequest request);

    /**
     * 修改敏感词规则
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/update_intercept_rule")
    Single<WeComResponse> updateInterceptRule(@Body ChatInterceptRuleUpdateRequest request);

    /**
     * 删除敏感词规则
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/del_intercept_rule")
    Single<WeComResponse> deleteInterceptRule(@Body InterceptRuleRequest request);
}
