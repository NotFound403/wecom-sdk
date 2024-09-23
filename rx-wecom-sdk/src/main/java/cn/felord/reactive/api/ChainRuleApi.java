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
import cn.felord.domain.corpgroup.ChainId;
import cn.felord.domain.corpgroup.ChainRule;
import cn.felord.domain.corpgroup.ChainRuleAddRequest;
import cn.felord.domain.corpgroup.ChainRuleModifyRequest;
import cn.felord.domain.corpgroup.RuleInfo;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 上下游规则
 * <p>
 * 上下游系统应用调用
 *
 * @author dax
 * @since 2024/10/13
 */
public interface ChainRuleApi {

    /**
     * 获取对接规则id列表
     * <p>
     * 上下游系统应用可通过该接口获取企业上下游规则id列表
     * <p>
     * 仅上下游系统应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param chainId the chain id
     * @return the generic response
     */
    @POST("corpgroup/rule/list_ids")
    Single<GenericResponse<List<Integer>>> listIds(@Body ChainId chainId);

    /**
     * 删除对接规则
     * <p>
     * 上下游系统应用可通过该接口删除企业上下游规则
     * <p>
     * 仅上下游系统应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param chainRule the chain rule
     * @return the we com response
     */
    @POST("corpgroup/rule/delete_rule")
    Single<WeComResponse> deleteRule(@Body ChainRule chainRule);

    /**
     * Gets rule info.
     *
     * @param chainRule the chain rule
     * @return the rule info
     */
    @POST("corpgroup/rule/get_rule_info")
    Single<GenericResponse<RuleInfo>> getRuleInfo(@Body ChainRule chainRule);

    /**
     * 新增对接规则
     * <p>
     * 上下游系统应用可通过该接口新增一条对接规则
     * <p>
     * 仅上下游系统应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param request the request
     * @return the we com response
     */
    @POST("corpgroup/rule/add_rule")
    Single<GenericResponse<Integer>> addRule(@Body ChainRuleAddRequest request);

    /**
     * 更新对接规则
     * <p>
     * 上下游应用可通过该接口修改一条对接规则
     * <p>
     * 仅上下游应用可调用，仅适用于上下游中创建空间的主企业调用。
     *
     * @param request the request
     * @return the we com response
     */
    @POST("corpgroup/rule/modify_rule")
    Single<WeComResponse> modifyRule(@Body ChainRuleModifyRequest request);
}
