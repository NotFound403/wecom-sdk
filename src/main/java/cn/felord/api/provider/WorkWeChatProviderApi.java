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

package cn.felord.api.provider;

import cn.felord.api.WorkWeChatApiClient;
import cn.felord.domain.GenericResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Collections;

/**
 * 三方应用开发专属API
 *
 * @author dax
 * @since 2021 /11/8 8:48
 */
final class WorkWeChatProviderApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Work we chat provider api.
     *
     * @param providerTokenApi the provider token api
     */
    public WorkWeChatProviderApi(ProviderTokenApi providerTokenApi) {
        this.workWeChatApiClient = new WorkWeChatApiClient(providerTokenApi);
    }

    /**
     * corpid的转换
     * <p>
     * 用于将企业主体的明文corpid转换为服务商主体的密文corpid。
     *
     * @param corpId the corp id
     * @return the generic response
     */
    public GenericResponse<String> corpidToOpencorpid(String corpId) {
        return workWeChatApiClient.post(WeComEndpoint.SERVICE_CORPID_TO_OPENCORPID, Collections.singletonMap("corpid", corpId), new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

}
