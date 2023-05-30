/*
 * Copyright (c) 2023. felord.cn
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *      https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.externalcontact.AgentCorpTagIterator;
import cn.felord.domain.externalcontact.CorpTagAddRequest;
import cn.felord.domain.externalcontact.CorpTagEditRequest;
import cn.felord.domain.externalcontact.CorpTagGroup;
import cn.felord.domain.externalcontact.CorpTagIterator;
import cn.felord.domain.externalcontact.CorpTagOptRequest;
import cn.felord.domain.externalcontact.CorpTagStrategyAddRequest;
import cn.felord.domain.externalcontact.CorpTagStrategyEditRequest;
import cn.felord.domain.externalcontact.StrategyCorpTagIterator;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

/**
 * The type Corp tag api.
 *
 * @author dax
 * @since 2021 /9/12 16:39
 */
public class CorpTagApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Corp tag api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    CorpTagApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 获取企业标签库
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the customer strategy detail response
     */
    public <R extends CorpTagIterator> GenericResponse<List<CorpTagGroup>> corpTagList(R request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_LIST, request, new ParameterizedTypeReference<GenericResponse<List<CorpTagGroup>>>() {
        });
    }

    /**
     * 添加企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<CorpTagGroup> addCorpTag(CorpTagAddRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_ADD, request, new ParameterizedTypeReference<GenericResponse<CorpTagGroup>>() {
        });
    }

    /**
     * 编辑企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public WeComResponse editCorpTag(CorpTagEditRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_EDIT, request, WeComResponse.class);
    }

    /**
     * 删除企业客户标签
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends AgentCorpTagIterator> WeComResponse delCorpTag(R request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_DEL, request, WeComResponse.class);
    }

    /**
     * 管理企业规则组下的客户标签
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends StrategyCorpTagIterator> GenericResponse<List<CorpTagGroup>> strategyCorpTagList(R request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_STRATEGY_LIST, request, new ParameterizedTypeReference<GenericResponse<List<CorpTagGroup>>>() {
        });
    }

    /**
     * 为指定规则组创建企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<CorpTagGroup> addStrategyCorpTag(CorpTagStrategyAddRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_STRATEGY_ADD, request, new ParameterizedTypeReference<GenericResponse<CorpTagGroup>>() {
        });
    }

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param request the request
     * @return the generic response
     */
    public WeComResponse editStrategyCorpTag(CorpTagStrategyEditRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_STRATEGY_EDIT, request, WeComResponse.class);
    }

    /**
     * 编辑指定规则组下的企业客户标签
     *
     * @param <R>     the type parameter
     * @param request the request
     * @return the generic response
     */
    public <R extends CorpTagIterator> WeComResponse delStrategyCorpTag(R request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_STRATEGY_DEL, request, WeComResponse.class);
    }

    /**
     * 编辑客户企业标签
     *
     * @param request the request
     * @return the we com response
     */
    public WeComResponse markTag(CorpTagOptRequest request) {
        return workWeChatApiClient.post(WeComEndpoint.CORP_TAG_MARK, request, WeComResponse.class);
    }
}
