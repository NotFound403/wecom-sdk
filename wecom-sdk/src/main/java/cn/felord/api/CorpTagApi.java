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
import cn.felord.domain.externalcontact.*;
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
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_corp_tag_list")
    GenericResponse<List<CorpTagGroup>> corpTagList(@Body CorpTagIterator request) throws WeComException;

    /**
     * 添加企业客户标签
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/add_corp_tag")
    GenericResponse<CorpTagGroup> addCorpTag(@Body CorpTagAddRequest request) throws WeComException;

    /**
     * 编辑企业客户标签
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/edit_corp_tag")
    WeComResponse editCorpTag(@Body CorpTagEditRequest request) throws WeComException;

    /**
     * 删除企业客户标签
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/del_corp_tag")
    WeComResponse delCorpTag(@Body AgentCorpTagIterator request) throws WeComException;

    /**
     * 管理企业规则组下的客户标签
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/get_strategy_tag_list")
    GenericResponse<List<CorpTagGroup>> strategyCorpTagList(@Body StrategyCorpTagIterator request) throws WeComException;

    /**
     * 为指定规则组创建企业客户标签
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/add_strategy_tag")
    GenericResponse<CorpTagGroup> addStrategyCorpTag(@Body CorpTagStrategyAddRequest request) throws WeComException;

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/edit_strategy_tag")
    WeComResponse editStrategyCorpTag(@Body CorpTagStrategyEditRequest request) throws WeComException;

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/del_strategy_tag")
    WeComResponse delStrategyCorpTag(@Body CorpTagIterator request) throws WeComException;

    /**
     * 编辑客户企业标签
     *
     * @param request the request
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("externalcontact/mark_tag")
    WeComResponse markTag(@Body CorpTagOptRequest request) throws WeComException;
}
