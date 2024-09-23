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
import cn.felord.domain.callcenter.knowledge.GroupsRequest;
import cn.felord.domain.callcenter.knowledge.GroupsResponse;
import cn.felord.domain.callcenter.knowledge.Intent;
import cn.felord.domain.callcenter.knowledge.IntentId;
import cn.felord.domain.callcenter.knowledge.IntentsRequest;
import cn.felord.domain.callcenter.knowledge.IntentsResponse;
import cn.felord.domain.callcenter.knowledge.KnowledgeGroup;
import cn.felord.domain.callcenter.knowledge.UpdateIntentRequest;
import cn.felord.domain.common.GroupId;
import cn.felord.domain.common.Name;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 微信客服-机器人-知识库API
 *
 * @author dax
 * @since 2024/10/5
 */
public interface KfKnowledgeApi {

    /**
     * 添加分组
     * <p>
     * 可通过此接口创建新的知识库分组。
     *
     * @param name the name
     * @return the we com response
     */
    @POST("kf/knowledge/add_group")
    Single<WeComResponse> addGroup(@Body Name name);

    /**
     * 删除分组
     * <p>
     * 可通过此接口删除已有的知识库分组，但不能删除系统创建的默认分组。
     *
     * @param groupId the group id
     * @return the we com response
     */
    @POST("kf/knowledge/del_group")
    Single<WeComResponse> delGroup(@Body GroupId groupId);

    /**
     * 修改分组
     * <p>
     * 可通过此接口修改已有的知识库分组，但不能修改系统创建的默认分组。
     *
     * @param group the group
     * @return the we com response
     */
    @POST("kf/knowledge/mod_group")
    Single<WeComResponse> modGroup(@Body KnowledgeGroup group);

    /**
     * 获取分组列表
     * <p>
     * 可通过此接口分页获取所有的知识库分组。
     *
     * @param request the request
     * @return the groups response
     */
    @POST("kf/knowledge/list_group")
    Single<GroupsResponse> listGroup(@Body GroupsRequest request);

    /**
     * 添加问答
     *
     * @param intent the intent
     * @return the groups response
     */
    @POST("kf/knowledge/add_intent")
    Single<GenericResponse<String>> addIntent(@Body Intent intent);

    /**
     * 删除问答
     *
     * @param intentId the intent id
     * @return the we com response
     */
    @POST("kf/knowledge/del_intent")
    Single<WeComResponse> delIntent(@Body IntentId intentId);

    /**
     * 修改问答
     * <p>
     * 可以按需更新，但更新的每一部分是覆盖写，需要传完整的字段。
     *
     * @param request the request
     * @return the we com response
     */
    @POST("kf/knowledge/mod_intent")
    Single<WeComResponse> modIntent(@Body UpdateIntentRequest request);

    /**
     * 获取问答列表
     *
     * @param request the request
     * @return the we com response
     */
    @POST("kf/knowledge/list_intent")
    Single<IntentsResponse> listIntent(@Body IntentsRequest request);
}
