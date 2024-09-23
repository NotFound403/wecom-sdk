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
import retrofit2.http.POST;

import java.util.List;

/**
 * The type Corp tag api.
 *
 * @author dax
 * @since 2021 /9/12 16:39
 */
public interface CorpTagApi {

    /**
     * 获取企业标签库
     *
     * @param request the request
     * @return the customer strategy detail response
     */
    @POST("externalcontact/get_corp_tag_list")
    Single<GenericResponse<List<CorpTagGroup>>> corpTagList(@Body CorpTagIterator request);

    /**
     * 添加企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/add_corp_tag")
    Single<GenericResponse<CorpTagGroup>> addCorpTag(@Body CorpTagAddRequest request);

    /**
     * 编辑企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/edit_corp_tag")
    Single<WeComResponse> editCorpTag(@Body CorpTagEditRequest request);

    /**
     * 删除企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/del_corp_tag")
    Single<WeComResponse> delCorpTag(@Body AgentCorpTagIterator request);

    /**
     * 管理企业规则组下的客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/get_strategy_tag_list")
    Single<GenericResponse<List<CorpTagGroup>>> strategyCorpTagList(@Body StrategyCorpTagIterator request);

    /**
     * 为指定规则组创建企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/add_strategy_tag")
    Single<GenericResponse<CorpTagGroup>> addStrategyCorpTag(@Body CorpTagStrategyAddRequest request);

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/edit_strategy_tag")
    Single<WeComResponse> editStrategyCorpTag(@Body CorpTagStrategyEditRequest request);

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    @POST("externalcontact/del_strategy_tag")
    Single<WeComResponse> delStrategyCorpTag(@Body CorpTagIterator request);

    /**
     * 编辑客户企业标签
     *
     * @param request the request
     * @return the we com response
     */
    @POST("externalcontact/mark_tag")
    Single<WeComResponse> markTag(@Body CorpTagOptRequest request);
}
